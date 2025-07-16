package com.warhammer.alfa.security;

import com.warhammer.alfa.metrics.MetricsService;
import com.warhammer.alfa.security.dto.AuthenticationRequest;
import com.warhammer.alfa.security.dto.AuthenticationResponse;
import com.warhammer.alfa.models.User.User;
import com.warhammer.alfa.models.User.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.warhammer.alfa.exceptions.UserAlreadyExistsException;
import com.warhammer.alfa.exceptions.InternalServerErrorException;
import com.warhammer.alfa.security.util.RsaDecryptionUtil;
import java.security.PrivateKey;
import java.util.Objects;

import com.warhammer.alfa.consts.ApplicationConsts;
import com.warhammer.alfa.email.email_confirmation.EmailConfirmationService;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.annotation.Counted;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PrivateKey privateKey;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final EmailConfirmationService emailConfirmationService;
    private final MetricsService metricsService;


    @Timed(value = "user.registration.duration", description = "Time taken to register a user")
    @Counted(value = "user.registration.success", description = "Total registration attempts ended in success")
    public AuthenticationResponse register(AuthenticationRequest request) {
        String decryptedPassword;
        try {
            decryptedPassword = RsaDecryptionUtil.decrypt(request.getPassword(), privateKey);
        } catch (Exception e) {
            metricsService.incrementUserRegistrations();
            throw new InternalServerErrorException("Password decryption failed");
        }
        
        // Check if user already exists
        if (userService.existsByEmail(request.getEmail())) {
            metricsService.incrementUserRegistrations();
            throw new UserAlreadyExistsException("User already exists with email: " + request.getEmail());
        }
        if (userService.existsByNickname(request.getUsername())) {
            metricsService.incrementUserRegistrations();
            throw new UserAlreadyExistsException("User already exists with nickname: " + request.getUsername());
        }
        
        // Create new user
        var user = new User()
            .setEmail(request.getEmail())
            .setPassword(passwordEncoder.encode(decryptedPassword))
            .setNickname(request.getUsername());

        // Save user to database
        userService.save(user);

        // Send confirmation email
        emailConfirmationService.sendConfirmationEmail(user);

        // Generate tokens
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Timed(value = "user.login.duration", description = "Time taken to authenticate a user")
    @Counted(value = "user.login.attempts", description = "Total login attempts")
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        String decryptedPassword;
        try {
            decryptedPassword = RsaDecryptionUtil.decrypt(request.getPassword(), privateKey);
        } catch (Exception e) {
            metricsService.incrementUserLogins();
            throw new InternalServerErrorException("Password decryption failed");
        }
        String login = Objects.requireNonNullElse(request.getEmail(), request.getUsername());
        
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(login, decryptedPassword)
        );
        var user = userService.findByLogin(login);
        
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        
        return AuthenticationResponse.builder()
            .token(jwtToken)
            .refreshToken(refreshToken)
            .build();
    }

    @Timed(value = "token.refresh.duration", description = "Time taken to refresh a token")
    public AuthenticationResponse refreshToken(String refreshToken) {
        String token = refreshToken.substring(ApplicationConsts.BEARER_LENGTH); // Remove "Bearer " prefix
        String username = jwtService.extractUsername(token);
        
        if (username != null) {
            var user = userService.findByLogin(username);
            
            if (jwtService.isTokenValid(token, user)) {
                var jwtToken = jwtService.generateToken(user);
                var newRefreshToken = jwtService.generateRefreshToken(user);
                
                return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .refreshToken(newRefreshToken)
                    .build();
            }
        }

        throw new InternalServerErrorException("Invalid refresh token");
    }
} 
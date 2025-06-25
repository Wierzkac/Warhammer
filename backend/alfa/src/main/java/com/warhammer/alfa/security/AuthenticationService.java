package com.warhammer.alfa.security;

import com.warhammer.alfa.security.dto.AuthenticationRequest;
import com.warhammer.alfa.security.dto.AuthenticationResponse;
import com.warhammer.alfa.models.User.User;
import com.warhammer.alfa.models.User.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.warhammer.alfa.exceptions.UserAlreadyExistsException;
import com.warhammer.alfa.exceptions.InternalServerErrorException;
import com.warhammer.alfa.security.util.RsaDecryptionUtil;
import java.security.PrivateKey;
import com.warhammer.alfa.email.EmailConfirmationService;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Value("${application.security.private-key}")
    private final PrivateKey PRIVATE_KEY;
    
    private final int BEARER_LENGTH = 7;

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final EmailConfirmationService emailConfirmationService;

    public AuthenticationResponse register(AuthenticationRequest request) {
        String decryptedPassword;
        try {
            decryptedPassword = RsaDecryptionUtil.decrypt(request.getPassword(), PRIVATE_KEY);
        } catch (Exception e) {
            throw new InternalServerErrorException("Password decryption failed");
        }
        // Check if user already exists
        if (userService.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("User already exists with email: " + request.getEmail());
        }
        if (userService.existsByNickname(request.getUsername())) {
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

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        String decryptedPassword;
        try {
            decryptedPassword = RsaDecryptionUtil.decrypt(request.getPassword(), PRIVATE_KEY);
        } catch (Exception e) {
            throw new InternalServerErrorException("Password decryption failed");
        }
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), decryptedPassword)
        );
        var user = userService.findByEmail(request.getEmail());
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        return AuthenticationResponse.builder()
            .token(jwtToken)
            .refreshToken(refreshToken)
            .build();
    }

    public AuthenticationResponse refreshToken(String refreshToken) {
        String token = refreshToken.substring(BEARER_LENGTH); // Remove "Bearer " prefix
        String userEmail = jwtService.extractUsername(token);
        
        if (userEmail != null) {
            var user = userService.findByEmail(userEmail);
            
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
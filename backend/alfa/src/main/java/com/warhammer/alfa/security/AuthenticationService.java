package com.warhammer.alfa.security;

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

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse register(AuthenticationRequest request) {
        // Check if user already exists
        if (userService.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("User already exists with email: " + request.getEmail());
        }
        if (userService.existsByNickname(request.getUsername())) {
            throw new UserAlreadyExistsException("User already exists with nickname: " + request.getUsername());
        }

        // Create new user
        var user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setNickname(request.getUsername());

        // Save user to database
        userService.save(user);

        // Generate tokens
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
            )
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
        String token = refreshToken.substring(7); // Remove "Bearer " prefix
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
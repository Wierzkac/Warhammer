package com.warhammer.alfa.email;

import com.warhammer.alfa.models.User.User;
import com.warhammer.alfa.models.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class EmailConfirmationService {

    private final int expiryHours = 2;
    
    private final UserService userService;
    private final EmailService emailService;
    
    public void sendConfirmationEmail(User user) {
        String token = generateConfirmationToken(user.getEmail());
        emailService.sendConfirmationEmail(user.getEmail(), token);
    }
    
    public boolean confirmEmail(String token) {
        try {
            String decodedToken = new String(Base64.getDecoder().decode(token));
            String[] parts = decodedToken.split("\\|");
            
            if (parts.length != 3) {
                return false;
            }
            
            String email = parts[0];
            String uuid = parts[1];
            LocalDateTime expiry = LocalDateTime.parse(parts[2]);
            
            if (expiry.isBefore(LocalDateTime.now())) {
                return false; // Token expired
            }
            
            User user = userService.findByEmail(email);
            user.setEnabled(true);
            userService.save(user);
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    private String generateConfirmationToken(String email) {
        String uuid = UUID.randomUUID().toString();
        LocalDateTime expiry = LocalDateTime.now().plusHours(expiryHours);
        String tokenData = email + "|" + uuid + "|" + expiry.toString();
        return Base64.getEncoder().encodeToString(tokenData.getBytes());
    }
} 
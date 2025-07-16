package com.warhammer.alfa.email.email_confirmation;

import com.warhammer.alfa.email.EmailService;
import com.warhammer.alfa.enums.EmailTypeEnum;
import com.warhammer.alfa.models.User.User;
import com.warhammer.alfa.models.User.UserService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailConfirmationService {

    private final int expiryMinutes;
    private final String emailURL;
    private final UserService userService;
    private final EmailService emailService;

    public EmailConfirmationService(
            @Value("${application.email.expiry-minutes}") int expiryMinutes,
            @Value("${application.email.url}") String emailURL,
            UserService userService,
            EmailService emailService,
            TemplateEngine templateEngine) {
        this.expiryMinutes = expiryMinutes;
        this.emailURL = emailURL;
        this.userService = userService;
        this.emailService = emailService;
    }
    
    public void sendConfirmationEmail(User user) {
        String token = generateConfirmationToken(user.getEmail());
        String confirmationUrl = emailURL + "/email/confirm?token=" + token;
        //EmailArguments arguments = new EmailConfirmationArguments(user.getNickname(), confirmationUrl, expiryMinutes);
        
        Map<String, String> arguments = new HashMap<>();
        arguments.put("username", user.getNickname());
        arguments.put("confirmationUrl", confirmationUrl);
        arguments.put("expiryMinutes", String.valueOf(expiryMinutes));

        emailService.saveEmail(user.getEmail(), "Confirm your Warhammer account", EmailTypeEnum.CONFIRM_REGISTRATION, arguments);
    }
    
    public void resendConfirmationEmail(String email) {
        User user = userService.findByLogin(email);
        if (user.isEnabled()) {
            throw new RuntimeException("User account is already confirmed");
        }
        sendConfirmationEmail(user);
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
            
            User user = userService.findByLogin(email);
            user.setEnabled(true);
            userService.save(user);
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    private String generateConfirmationToken(String email) {
        String uuid = UUID.randomUUID().toString();
        LocalDateTime expiry = LocalDateTime.now().plusMinutes(expiryMinutes);
        String tokenData = email + "|" + uuid + "|" + expiry.toString();
        return Base64.getEncoder().encodeToString(tokenData.getBytes());
    }
} 
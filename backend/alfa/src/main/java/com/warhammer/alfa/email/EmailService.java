package com.warhammer.alfa.email;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    
    private final JavaMailSender mailSender;
    
    public void sendConfirmationEmail(String to, String confirmationToken) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Confirm your Warhammer account");
        message.setText("Please click the following link to confirm your account: " +
                       "http://localhost:3000/confirm-email?token=" + confirmationToken);
        
        mailSender.send(message);
    }
    
    public void sendPasswordResetEmail(String to, String resetToken) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Reset your Warhammer password");
        message.setText("Please click the following link to reset your password: " +
                       "http://localhost:3000/reset-password?token=" + resetToken);
        
        mailSender.send(message);
    }
} 
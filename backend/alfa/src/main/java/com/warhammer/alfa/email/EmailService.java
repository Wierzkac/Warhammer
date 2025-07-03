package com.warhammer.alfa.email;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class EmailService {
    
    private final JavaMailSender mailSender;

    /**
     * Send an email, supporting both plain text and HTML content.
     * @param recipient the recipient's email address
     * @param subject the subject of the email
     * @param content the email body (plain text or HTML)
     */
    @Async
    public void sendEmail(String recipient, String subject, String content) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setTo(recipient);
            helper.setSubject(subject);
            helper.setText(content);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }
} 
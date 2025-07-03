package com.warhammer.alfa.email;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmailServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @Mock
    private MimeMessage mimeMessage;

    @InjectMocks
    private EmailService emailService;

    @Test
    void sendEmail_ShouldSendPlainTextEmail() throws MessagingException {
        // Given
        String recipient = "test@example.com";
        String subject = "Test Subject";
        String content = "Test content";
        
        when(mailSender.createMimeMessage()).thenReturn(mimeMessage);
        doNothing().when(mailSender).send(any(MimeMessage.class));

        // When
        emailService.sendEmail(recipient, subject, content);

        // Then
        verify(mailSender, times(1)).createMimeMessage();
        verify(mailSender, times(1)).send(mimeMessage);
    }

    @Test
    void sendEmail_ShouldSendHtmlEmail() throws MessagingException {
        // Given
        String recipient = "test@example.com";
        String subject = "Test Subject";
        String htmlContent = "<html><body><h1>Test</h1></body></html>";
        
        when(mailSender.createMimeMessage()).thenReturn(mimeMessage);
        doNothing().when(mailSender).send(any(MimeMessage.class));

        // When
        emailService.sendEmail(recipient, subject, htmlContent);

        // Then
        verify(mailSender, times(1)).createMimeMessage();
        verify(mailSender, times(1)).send(mimeMessage);
    }

    @Test
    void sendEmail_ShouldHandleMessagingException() throws MessagingException {
        // Given
        String recipient = "test@example.com";
        String subject = "Test Subject";
        String content = "Test content";
        
        when(mailSender.createMimeMessage()).thenReturn(mimeMessage);
        doThrow(new RuntimeException("Test exception")).when(mailSender).send(any(MimeMessage.class));

        // When & Then
        try {
            emailService.sendEmail(recipient, subject, content);
        } catch (RuntimeException e) {
            // Expected
        }
    }
} 
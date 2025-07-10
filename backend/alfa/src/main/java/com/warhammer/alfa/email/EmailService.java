package com.warhammer.alfa.email;

import com.warhammer.alfa.metrics.MetricsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import io.micrometer.core.annotation.Timed;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
    
    private final JavaMailSender mailSender;
    private final EmailRepository emailRepository;

    /**
     * Save an email to the database for later sending.
     * @param recipient the recipient's email address
     * @param subject the subject of the email
     * @param content the email body (plain text or HTML)
     */
    public void sendEmail(String recipient, String subject, String content) {
        EmailEntity email = new EmailEntity()
            .setRecipient(recipient)
            .setSubject(subject)
            .setContent(content)
            .setStatus("TO_BE_SENT")
            .setCreatedAt(LocalDateTime.now())
            .setUpdatedAt(LocalDateTime.now());

        emailRepository.save(email);
        log.info("Email saved to database for recipient: {}", recipient);
    }

    /**
     * Send a single email from the database.
     */
    @Timed(value = "email.sending.duration", description = "Time taken to send an email")
    private void sendEmailFromDatabase(EmailEntity email) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        helper.setTo(email.getRecipient());
        helper.setSubject(email.getSubject());

        // Check if content looks like HTML and set content type accordingly
        boolean isHtml = email.getContent().contains("<html") || email.getContent().contains("<body");
        helper.setText(email.getContent(), isHtml);

        mailSender.send(mimeMessage);
    }

    @Scheduled(cron = "0 */5 * * * *")
    public void sendPendingEmails() {
        log.info("Starting scheduled email sending job");
        try {
            List<EmailEntity> pendingEmails = emailRepository.findByStatus("TO_BE_SENT");

            if (pendingEmails.isEmpty()) {
                log.debug("No pending emails to send");
                return;
            }

            log.info("Found {} pending emails to send", pendingEmails.size());

            for (EmailEntity email : pendingEmails) {
                try {
                    sendEmailFromDatabase(email);
                    email.setStatus("SENT");
                    email.setUpdatedAt(LocalDateTime.now());
                    emailRepository.save(email);
                    log.info("Email sent successfully to: {}", email.getRecipient());
                } catch (Exception e) {
                    log.error("Failed to send email to {}: {}", email.getRecipient(), e.getMessage());
                }
            }
            log.info("Scheduled email sending job completed");
        } catch (Exception e) {
            log.error("Error during scheduled email sending: {}", e.getMessage(), e);
        }
    }
}
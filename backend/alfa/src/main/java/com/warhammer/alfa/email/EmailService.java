package com.warhammer.alfa.email;

import com.warhammer.alfa.enums.EmailStatusEnum;
import com.warhammer.alfa.enums.EmailTypeEnum;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import io.micrometer.core.annotation.Timed;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
    
    private final JavaMailSender mailSender;
    private final EmailRepository emailRepository;
    private final TemplateEngine templateEngine;

    /**
     * Save an email to the database for later sending.
     * @param recipient the recipient's email address
     * @param subject the subject of the email
     * @param emailType the type of email to send
     * @param arguments the arguments to include in the email (e.g., username, link)
     */
    public void saveEmail(String recipient, String subject, EmailTypeEnum emailType, Map<String, String> arguments) {
        EmailEntity email = new EmailEntity()
            .setRecipient(recipient)
            .setSubject(subject)
            .setStatus(EmailStatusEnum.PENDING)
            .setEmailType(emailType)
            .setArguments(arguments)
            .setCreatedAt(LocalDateTime.now())
            .setUpdatedAt(LocalDateTime.now());
        emailRepository.save(email);
        log.info("Email saved to database for recipient: {}", recipient);
    }

    @Scheduled(cron = "0 * * * * *")
    @Transactional
    public void sendPendingEmails() {
        try {
            List<EmailEntity> pendingEmails = emailRepository.findByStatusForUpdate(EmailStatusEnum.PENDING);

            if (pendingEmails.isEmpty()) {
                log.debug("No pending emails to send");
                return;
            }

            log.info("Found {} pending emails to send", pendingEmails.size());

            for (EmailEntity email : pendingEmails) {
                try {
                    sendEmailFromDatabase(email);
                    email.setStatus(EmailStatusEnum.SENT);
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

    /**
     * Send a single email from the database.
     */
    @Timed(value = "email.sending.duration", description = "Time taken to send an email")
    private void sendEmailFromDatabase(EmailEntity email) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        helper.setTo(email.getRecipient());
        helper.setSubject(email.getSubject());

        String content = generateEmailContent(email);
        boolean isHtml = content.contains("<html") || content.contains("<body");
        helper.setText(content, isHtml);

        mailSender.send(mimeMessage);
    }

    /**
     * Generate email content based on type and arguments using Thymeleaf.
     */
    private String generateEmailContent(EmailEntity email) {
        Context context = new Context();
        if (email.getArguments() != null) {
            for (Map.Entry<String, String> entry : email.getArguments().entrySet()) {
                context.setVariable(entry.getKey(), entry.getValue());
            }
            // for (RecordComponent component : email.getArguments().getClass().getRecordComponents()) {
            //     try {
            //         Object value = component.getAccessor().invoke(email.getArguments());
            //         context.setVariable(component.getName(), value);
            //     } catch (Exception e) {
            //         log.error("Failed to access record component {}: {}", component.getName(), e.getMessage());
            //     }
            // }
        }
        String templateName;
        switch (email.getEmailType()) {
            case CONFIRM_REGISTRATION:
                templateName = "email/confirmation";
                break;
            case PASSWORD_RESET:
                templateName = "email/password_reset";
                break;
            default:
                templateName = "email/default";
        }
        return templateEngine.process(templateName, context);
    }
}
package com.warhammer.alfa.email;

import com.warhammer.alfa.email.email_confirmation.EmailConfirmationService;
import com.warhammer.alfa.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EmailController {

    private final EmailConfirmationService emailConfirmationService;

    @GetMapping("/confirm")
    public ResponseEntity<Map<String, Object>> confirmEmail(@RequestParam String token) {
        boolean success = emailConfirmationService.confirmEmail(token);
        
        Map<String, Object> response = new HashMap<>();
        
        if (success) {
            response.put("success", true);
            response.put("message", "Email confirmed successfully! Your account is now active.");
        } else {
            response.put("success", false);
            response.put("message", "Invalid or expired confirmation token. Please request a new confirmation email.");
        }
        
        return ResponseEntity.ok(response);
    }

    @PostMapping("/resend-confirmation")
    public ResponseEntity<Map<String, Object>> resendConfirmationEmail(@RequestParam String email) {
        try {
            emailConfirmationService.resendConfirmationEmail(email);
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Confirmation email sent successfully!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new BadRequestException("Failed to resend confirmation email: " + e.getMessage());
        }
    }
} 
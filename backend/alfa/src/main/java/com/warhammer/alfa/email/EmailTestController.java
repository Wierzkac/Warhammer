package com.warhammer.alfa.email;

import org.springframework.web.bind.annotation.*;

import com.warhammer.alfa.models.User.User;

@RestController
@RequestMapping("/test/email")
public class EmailTestController {

    private final EmailConfirmationService emailConfirmationService;

    public EmailTestController(EmailConfirmationService emailConfirmationService) {
        this.emailConfirmationService = emailConfirmationService;
    }

    @GetMapping("/{email}")
    public String sendTestEmail(@PathVariable String email) {
        
        User user = new User();
        user.setEmail(email);
        user.setNickname("Test User");

        emailConfirmationService.sendConfirmationEmail(user);
        return "Email sent successfully to " + user.getEmail();
    }
}
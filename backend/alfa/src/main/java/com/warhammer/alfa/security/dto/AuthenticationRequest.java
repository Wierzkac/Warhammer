package com.warhammer.alfa.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@AtLeastOneOfUsernameOrEmail
public class AuthenticationRequest {
    private String username;

    @Email
    private String email;

    @NotBlank
    @Size(max = 512)
    private String password;
} 
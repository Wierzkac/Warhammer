package com.warhammer.alfa.models.User;

import com.warhammer.alfa.enums.RoleEnum;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String nickname;
    private String profileImageUrl;
    private RoleEnum role;
    private boolean enabled;
}
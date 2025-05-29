package com.warhammer.alfa.models.User;

import com.warhammer.alfa.enums.RoleEnum;
import com.warhammer.alfa.models.Character.CharacterDTO;
import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String nickname;
    private String profileImageUrl;
    private Set<CharacterDTO> characters;
    private RoleEnum role;
    private boolean enabled;
}
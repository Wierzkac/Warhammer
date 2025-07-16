package com.warhammer.alfa.models.User;

import com.warhammer.alfa.models.Image.ImageRepository;
import com.warhammer.alfa.models.Image.ImageType;
import com.warhammer.alfa.models.Image.EntityType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;
    private final ImageRepository imageRepository;

    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        
        User user = userService.findByLogin(username);
        
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setNickname(user.getNickname());
        userDTO.setRole(user.getRole());
        userDTO.setEnabled(user.isEnabled());
        
        // Get the active profile image URL
        String profileImageUrl = imageRepository.findActiveImageByTypeAndEntity(ImageType.USER_PROFILE, EntityType.USER, user.getId())
                .map(image -> "/api/images/" + image.getId()) // This will be the endpoint to serve the image
                .orElse(null);
        userDTO.setProfileImageUrl(profileImageUrl);
        
        // Note: characters are not loaded by default to avoid performance issues
        
        return ResponseEntity.ok(userDTO);
    }
}

package com.warhammer.alfa.models.Image;

import com.warhammer.alfa.models.User.User;
import com.warhammer.alfa.models.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.Map;

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ImageController {

    private final ImageRepository imageRepository;
    private final UserService userService;
    private final Path uploadPath = Paths.get("uploads");

    @PostMapping("/upload/profile")
    public ResponseEntity<?> uploadProfileImage(@RequestParam("file") MultipartFile file) {
        try {
            // Ensure upload directory exists
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Get current user
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            User user = userService.findByLogin(username);

            // Generate unique filename
            String originalFilename = file.getOriginalFilename();
            String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String uniqueFilename = UUID.randomUUID().toString() + fileExtension;

            // Save file
            Path filePath = uploadPath.resolve(uniqueFilename);
            Files.copy(file.getInputStream(), filePath);

            // Deactivate previous profile images for this user
            imageRepository.findAllByTypeAndEntityOrderByUploadedAtDesc(ImageType.USER_PROFILE, EntityType.USER, user.getId())
                    .forEach(image -> {
                        image.setActive(false);
                        imageRepository.save(image);
                    });

            // Create new image record
            Image image = new Image();
            image.setFileName(uniqueFilename);
            image.setOriginalFileName(originalFilename);
            image.setContentType(file.getContentType());
            image.setFileSize(file.getSize());
            image.setFilePath(filePath.toString());
            image.setImageType(ImageType.USER_PROFILE);
            image.setEntityType(EntityType.USER);
            image.setEntityId(user.getId());
            image.setActive(true);

            Image savedImage = imageRepository.save(image);

            return ResponseEntity.ok().body(Map.of(
                "message", "Profile image uploaded successfully",
                "imageId", savedImage.getId(),
                "imageUrl", "/api/images/" + savedImage.getId()
            ));

        } catch (IOException e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Failed to upload image: " + e.getMessage()));
        }
    }

    @GetMapping("/{imageId}")
    public ResponseEntity<Resource> getImage(@PathVariable Long imageId) {
        try {
            Image image = imageRepository.findById(imageId)
                    .orElseThrow(() -> new RuntimeException("Image not found"));

            Path filePath = Paths.get(image.getFilePath());
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists() && resource.isReadable()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(image.getContentType()))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + image.getOriginalFileName() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{imageId}")
    public ResponseEntity<?> deleteImage(@PathVariable Long imageId) {
        try {
            // Get current user
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            User user = userService.findByLogin(username);

            Image image = imageRepository.findById(imageId)
                    .orElseThrow(() -> new RuntimeException("Image not found"));

            // Check if user owns this image
            if (!image.getEntityId().equals(user.getId()) || image.getImageType() != ImageType.USER_PROFILE) {
                return ResponseEntity.status(403).build();
            }

            // Delete file from filesystem
            Path filePath = Paths.get(image.getFilePath());
            Files.deleteIfExists(filePath);

            // Delete from database
            imageRepository.delete(image);

            return ResponseEntity.ok().body(Map.of("message", "Image deleted successfully"));

        } catch (IOException e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Failed to delete image: " + e.getMessage()));
        }
    }
} 
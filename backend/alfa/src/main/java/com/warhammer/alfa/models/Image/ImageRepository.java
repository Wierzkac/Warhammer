package com.warhammer.alfa.models.Image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    
    @Query("SELECT i FROM Image i WHERE i.imageType = :imageType AND i.entityType = :entityType AND i.entityId = :entityId AND i.isActive = true")
    Optional<Image> findActiveImageByTypeAndEntity(@Param("imageType") ImageType imageType, @Param("entityType") EntityType entityType, @Param("entityId") Long entityId);
    
    @Query("SELECT i FROM Image i WHERE i.imageType = :imageType AND i.entityType = :entityType AND i.entityId = :entityId ORDER BY i.uploadedAt DESC")
    List<Image> findAllByTypeAndEntityOrderByUploadedAtDesc(@Param("imageType") ImageType imageType, @Param("entityType") EntityType entityType, @Param("entityId") Long entityId);
    
    @Query("SELECT i FROM Image i WHERE i.imageType = :imageType ORDER BY i.uploadedAt DESC")
    List<Image> findAllByTypeOrderByUploadedAtDesc(@Param("imageType") ImageType imageType);
} 
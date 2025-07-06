package com.warhammer.alfa.email;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<EmailEntity, Integer> {
    
    List<EmailEntity> findByStatus(String status);
}

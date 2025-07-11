package com.warhammer.alfa.email;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.warhammer.alfa.enums.EmailStatusEnum;
import jakarta.persistence.LockModeType;

@Repository
public interface EmailRepository extends JpaRepository<EmailEntity, Integer> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT e FROM EmailEntity e WHERE e.status = :status")
    List<EmailEntity> findByStatusForUpdate(EmailStatusEnum status);
}

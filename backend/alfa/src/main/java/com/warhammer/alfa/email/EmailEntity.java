package com.warhammer.alfa.email;

import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "emails_to_send")
public class EmailEntity {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    protected int id;

    @Column(nullable = false)
    protected String recipient;
    
    @Column(nullable = false)
    protected String subject;
    
    @Column(columnDefinition = "LONGTEXT", nullable = false)
    protected String content;
    
    @Column(nullable = false)
    protected String status;
    
    @Column(nullable = false)
    protected LocalDateTime createdAt;
    
    @Column(nullable = false)
    protected LocalDateTime updatedAt;
    
}

package com.warhammer.alfa.email;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.annotations.GenericGenerator;

import com.warhammer.alfa.enums.EmailStatusEnum;
import com.warhammer.alfa.enums.EmailTypeEnum;

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
    protected Integer id;

    @Column(nullable = false)
    protected String recipient;
    
    @Column(nullable = false)
    protected String subject;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    protected EmailStatusEnum status;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    protected EmailTypeEnum emailType;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "email_arguments", joinColumns = @JoinColumn(name = "email_id"))
    @MapKeyColumn(name = "argument_key")
    @Column(name = "argument_value")
    protected Map<String, String> arguments = new HashMap<>();
    //protected EmailArguments arguments;
    
    @Column(nullable = false)
    protected LocalDateTime createdAt;
    
    @Column(nullable = false)
    protected LocalDateTime updatedAt;
    
}
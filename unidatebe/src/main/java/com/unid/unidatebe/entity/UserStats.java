package com.unid.unidatebe.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.ToString;

@Document(collection = "user_stats")
@Data
@ToString
public class UserStats {
    @Id
    private String userId;
    
    private int likesGiven;
    private int likesReceived;
    private int matches;
    private int messagesSent;
    private LocalDateTime lastMatchDate;
    
    // Costruttori, getters e setters
}

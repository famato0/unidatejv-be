package com.unid.unidatebe.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList; // Aggiungi questo import
import java.util.List;
import java.time.LocalDateTime;

@Document(collection = "matches")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Match {
    @Id
    private String id;

    @NotBlank
    private String user1Id;

    @NotBlank
    private String user2Id;

    @Builder.Default
    private LocalDateTime matchedAt = LocalDateTime.now();

    @Builder.Default
    private boolean isActive = true;

    //TODO - Verificare come gestire chat live (non devi scaricarti nulla devi mettere tutto in sessione credo)
    //@Builder.Default
    //private List<String> messageIds = new ArrayList<>();
}

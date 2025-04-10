package com.unid.unidatebe.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.unid.unidatebe.enums.PhotoStatusEnum;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Document(collection = "photos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Photo {
    @Id
    private String id;

    @NotBlank
    private String s3Key; // Chiave unica per S3

    @NotBlank
    private String encryptedKey; // Chiave crittografata con KMS

    @NotBlank
    private String iv; // Initialization Vector per AES

    @NotBlank
    private String contentType; // es. "image/jpeg"

    private long size; // Dimensione in bytes

    @NotBlank
    private String hash; // SHA-256 del file originale

    @Builder.Default
    private PhotoStatusEnum status = PhotoStatusEnum.PENDING_REVIEW; // Riferimento all'enum

    private LocalDateTime uploadDate;

    @NotBlank
    private String uploadedBy; // User ID
}
package com.unid.unidatebe.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Document(collection = "universities")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class University {
    @Id
    private String id;

    @Indexed(unique = true)
    @NotBlank
    private String name;

    @NotBlank
    private String city;

    @NotBlank
    @Indexed(unique = true)
    private String acronym;

    @NotBlank
    @Pattern(regexp = "^.*\\.edu\\.it$")
    private String emailDomain;

    @Builder.Default
    private boolean verified = true;

    //private double latitude;
    //private double longitude;
}

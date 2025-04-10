package com.unid.unidatebe.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.unid.unidatebe.enums.GenderEnum;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {
    @Id
    private String id;

    @Indexed(unique = true)
    @NotBlank
    @Size(max = 120)
    private String authId;

    @NotBlank
    @Size(min = 2, max = 30)
    private String username;

    @Size(max = 100)
    private String bio;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private GenderEnum gender;

    @DBRef
    private University university;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.edu\\.it$") //TODO - Questa regex non funziona
    private String institutionalEmail;

    @Builder.Default
    private String faculty = "NOT_SPECIFIED"; //TODO - Crea gli enum

    @Builder.Default
    private String degreeCourse = "NOT_SPECIFIED"; //TODO - Crea gli enum

    @NotNull
    @Singular("interest") // Specifica esplicitamente la forma singolare
    private List<GenderEnum> interestedIn; //NOTE - non so a cosa serva Singular

    @NotNull
    private Location location;

    //@Builder.Default
    //private List<Photo> photos = new ArrayList<>();

    @Singular
    private List<String> hobbies;

    private boolean verified;
    private boolean active;

    //@Builder.Default
    //private Set<String> blockedUsers = new HashSet<>();

    private LocalDateTime lastActive;

    // Calcolo età (non persistito)
    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
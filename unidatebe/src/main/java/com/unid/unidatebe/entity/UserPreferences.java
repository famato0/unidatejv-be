package com.unid.unidatebe.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.unid.unidatebe.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

@Document(collection = "user_preferences")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserPreferences {
    @Id
    private String userId;

    @Builder.Default
    private int minAge = 18;

    @Builder.Default
    private int maxAge = 99;

    @Builder.Default
    private int maxDistance = 50; // in km

    @Singular
    private List<GenderEnum> preferredGenders;

    @Builder.Default
    private boolean onlyVerified = false;
}

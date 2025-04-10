package com.unid.unidatebe.entity;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @NotBlank
    private String city;

    @NotBlank
    private String country;

    private GeoJsonPoint coordinates; // Per query geospaziali

    @Builder.Default
    private boolean hideExactLocation = true;
}
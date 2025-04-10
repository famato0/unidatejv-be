package com.unid.unidatebe.enums;

import java.util.Arrays;

public enum GenderEnum {
    MALE, FEMALE, NON_BINARY, TRANSGENDER, GENDERQUEER, 
    GENDERFLUID, AGENDER, BIGENDER, OTHER;

    public static boolean isValid(String value) {
        return Arrays.stream(values())
            .anyMatch(e -> e.name().equalsIgnoreCase(value));
    }
}

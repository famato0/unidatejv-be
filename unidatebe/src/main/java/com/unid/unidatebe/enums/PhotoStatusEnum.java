package com.unid.unidatebe.enums;

import java.util.Arrays;

public enum PhotoStatusEnum {
    PENDING_REVIEW, APPROVED, REJECTED, DELETED;

    public static boolean isValid(String value) {
        return Arrays.stream(values())
            .anyMatch(e -> e.name().equalsIgnoreCase(value));
    }
}

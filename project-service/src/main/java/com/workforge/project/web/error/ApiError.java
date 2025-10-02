package com.workforge.project.web.error;

import java.time.OffsetDateTime;
import java.util.List;

public record ApiError(
        String type,
        String message,
        List<String> details,
        OffsetDateTime timestamp) {
    public static ApiError of(String type, String message, List<String> details) {
        return new ApiError(type, message, details, OffsetDateTime.now());
    }
}

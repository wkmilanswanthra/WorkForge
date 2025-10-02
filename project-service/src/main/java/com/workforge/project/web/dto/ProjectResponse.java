package com.workforge.project.web.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

public record ProjectResponse(
    UUID id,
    String name,
    String description,
    OffsetDateTime createdAt,
    OffsetDateTime updatedAt
) {}

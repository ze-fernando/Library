package com.zefernando.library.models.dtos;

import com.zefernando.library.models.enums.AgeGroup;
import com.zefernando.library.models.enums.Status;

public record BookDto(
    String title,
    Integer year,
    Status status,
    String author,
    String category,
    AgeGroup ageGroup
) {}

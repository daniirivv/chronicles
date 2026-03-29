package edu.chronicles.presentation.dtos;

import edu.chronicles.domain.models.Rating;

import java.time.Year;

public record BookResponseDto(
        String title,
        String author,
        int pages,
        Year releaseDate,
        boolean completed,
        Rating rating
) {
}

package edu.chronicles.presentation.dtos;

import java.time.Year;

public record BookCreateDto(
        String title,
        String author,
        Integer pages,
        Year releaseDate,
        boolean completed,
        Integer rating
) {

}

package edu.chronicles.presentation.dtos;

import edu.chronicles.domain.models.Rating;

import java.time.Year;

public record BookCreateDto(
        String title,
        String author,
        int pages,
        Year releaseDate,
        boolean completed,
        Rating rating
) {

    public int getRatingValue(){
        return rating.value();
    }

}

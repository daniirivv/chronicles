package edu.chronicles.back.logic.mappers;

import edu.chronicles.back.display.dtos.BookDto;
import edu.chronicles.back.logic.models.BookEntry;

public class BookMapper {

    public static BookEntry toDomain(BookDto dto) throws IllegalArgumentException {

        return BookEntry.builder()
                .title(dto.title())
                .author(dto.author())
                .pages(dto.pages())
                .releaseDate(dto.releaseDate())
                .completed(dto.completed())
                .rating((dto.rating() == null) ? null : dto.rating())
                .build();
    }

    public static BookDto toDto(BookEntry entry) throws IllegalArgumentException {

        return BookDto.builder()
                .title(entry.getTitle())
                .author(entry.getAuthor())
                .pages(entry.getPages())
                .releaseDate(entry.getReleaseDate())
                .completed(entry.isCompleted())
                .rating(entry.getRating())
                .build();
    }

}

package edu.danilorena.chronicles.logic.mappers;

import edu.danilorena.chronicles.display.dtos.BookDto;
import edu.danilorena.chronicles.logic.models.BookEntry;

public class BookMapper {

    public static BookEntry toDomain(BookDto dto) throws IllegalArgumentException {

        return BookEntry.builder()
                .id(dto.id())
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
                .id(entry.id())
                .title(entry.title())
                .author(entry.author())
                .pages(entry.pages())
                .releaseDate(entry.releaseDate())
                .completed(entry.completed())
                .rating(entry.rating().value())
                .build();
    }

}

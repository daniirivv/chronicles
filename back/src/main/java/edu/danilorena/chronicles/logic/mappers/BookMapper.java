package edu.danilorena.chronicles.logic.mappers;

import edu.danilorena.chronicles.display.dtos.BookRequestDto;
import edu.danilorena.chronicles.display.dtos.BookResponseDto;
import edu.danilorena.chronicles.logic.models.BookEntry;

public class BookMapper {

    public static BookEntry toDomain(BookRequestDto dto) throws IllegalArgumentException {

        return BookEntry.builder()
                .title(dto.title())
                .author(dto.author())
                .pages(dto.pages())
                .releaseDate(dto.releaseDate())
                .completed(dto.completed())
                .rating((dto.rating() == null) ? null : dto.rating())
                .build();
    }

    public static BookResponseDto toResponseDto(BookEntry entry) throws IllegalArgumentException {

        return BookResponseDto.builder()
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

package edu.chronicles.domain.mappers;

import edu.chronicles.domain.models.BookEntry;
import edu.chronicles.domain.models.Rating;
import edu.chronicles.presentation.dtos.BookCreateDto;
import edu.chronicles.presentation.dtos.BookResponseDto;

public class BookMapper {

    public static BookEntry toDomain(BookCreateDto dto) throws IllegalArgumentException {
        return new BookEntry(
                dto.title(),
                dto.author(),
                dto.pages(),
                dto.releaseDate(),
                dto.completed(),
                new Rating(dto.rating())
        );
    }

    public static BookResponseDto toResponseDto(BookEntry bookEntry) {
        return new BookResponseDto(
                bookEntry.getTitle(),
                bookEntry.getAuthor(),
                bookEntry.getPages(),
                bookEntry.getReleaseDate(),
                bookEntry.isCompleted(),
                bookEntry.getRating()
        );
    }

}

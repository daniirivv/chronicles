package edu.chronicles.domain.mappers;

import edu.chronicles.domain.models.BookEntry;
import edu.chronicles.domain.models.Rating;
import edu.chronicles.presentation.dtos.BookCreateDto;

public class BookMapper {

    public static BookEntry toDomain(BookCreateDto dto) throws IllegalArgumentException{
        return new BookEntry(
                dto.title(),
                dto.author(),
                dto.pages(),
                dto.releaseDate(),
                dto.completed(),
                new Rating(dto.getRatingValue())
        );
    }

    public static BookCreateDto toCreateDto(BookEntry bookEntry) {
        return new BookCreateDto(
                bookEntry.getTitle(),
                bookEntry.getAuthor(),
                bookEntry.getPages(),
                bookEntry.getReleaseDate(),
                bookEntry.isCompleted(),
                bookEntry.getRating()
        );
    }

}

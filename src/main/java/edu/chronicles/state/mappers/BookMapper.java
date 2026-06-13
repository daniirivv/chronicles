package edu.chronicles.state.mappers;

import edu.chronicles.state.entries.BookEntry;
import edu.chronicles.state.enums.CompletionState;
import edu.chronicles.state.value_objects.UserRating;
import edu.chronicles.display.dtos.BookCreateDto;
import edu.chronicles.display.dtos.BookResponseDto;

public class BookMapper {

    public static BookEntry toDomain(BookCreateDto dto) throws IllegalArgumentException {
        CompletionState state = (dto.completed()) ? CompletionState.TERMINADO : CompletionState.PLANEADO;

        return new BookEntry(
                0L,
                dto.title(),
                dto.author(),
                dto.pages(),
                dto.releaseDate(),
                new UserRating(dto.rating())
        );
    }

    public static BookResponseDto toResponseDto(BookEntry bookEntry) {
        boolean completed = bookEntry.getState().equals(CompletionState.TERMINADO);

        return new BookResponseDto(
                bookEntry.getBookTitle(),
                bookEntry.getAuthor(),
                bookEntry.getPages(),
                bookEntry.getReleaseYear(),
                completed,
                bookEntry.getRating().value()
        );
    }

}

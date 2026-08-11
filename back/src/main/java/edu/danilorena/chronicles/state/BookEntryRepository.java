package edu.danilorena.chronicles.state;

import edu.danilorena.chronicles.display.dtos.BookResponseDto;
import edu.danilorena.chronicles.logic.mappers.BookMapper;
import edu.danilorena.chronicles.logic.models.BookEntry;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookEntryRepository {

    private long nextId = 1L;

    private final Map<Long, BookEntry> bookEntryMap = new HashMap<>();

    public Optional<BookEntry> findById(Long id) {
        return Optional.ofNullable(this.bookEntryMap.get(id));
    }

    public Optional<BookEntry> findByTitle(String title) {
        return this.bookEntryMap
                .values()
                .stream()
                .filter(entry -> entry.title().equals(title))
                .findFirst();
    }

    public List<BookEntry> filterByAuthor(String authorPrefix) {
        if (authorPrefix == null || authorPrefix.isBlank()) {
            return List.of();
        }

        String lowerPrefix = authorPrefix.toLowerCase();

        return this.bookEntryMap
                .values()
                .stream()
                .filter(entry -> entry.author() != null && entry.author().toLowerCase().startsWith(lowerPrefix))
                .toList();
    }

    public BookEntry save(BookEntry bookEntry) {
        BookEntry toSave = BookEntry.builder()
                .id(nextId++)
                .title(bookEntry.title())
                .author(bookEntry.author())
                .pages(bookEntry.pages())
                .releaseDate(bookEntry.releaseDate())
                .completed(bookEntry.completed())
                .rating(bookEntry.getRatingValue())
                .build();

        this.bookEntryMap.put(toSave.id(),  toSave);
        return toSave;
    }

    public BookEntry update(BookEntry bookEntry) {
        this.bookEntryMap.replace(bookEntry.id(), bookEntry);
        return bookEntry;
    }

    public BookEntry delete(BookEntry bookEntry) {
        this.bookEntryMap.remove(bookEntry.id(), bookEntry);
        return bookEntry;
    }

    public List<BookResponseDto> getAll() {
        if (this.bookEntryMap.isEmpty()) return List.of();

        List<BookResponseDto> bookResponseDtoList = new ArrayList<>();
        for (BookEntry bookEntry : this.bookEntryMap.values()) {
            bookResponseDtoList.add(BookMapper.toResponseDto(bookEntry));
        }

        return bookResponseDtoList;
    }
}

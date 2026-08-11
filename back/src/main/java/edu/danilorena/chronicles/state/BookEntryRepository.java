package edu.danilorena.chronicles.state;

import edu.danilorena.chronicles.display.dtos.BookDto;
import edu.danilorena.chronicles.logic.mappers.BookMapper;
import edu.danilorena.chronicles.logic.models.BookEntry;
import org.springframework.stereotype.Repository;

import java.text.Normalizer;
import java.util.*;

@Repository
public class BookEntryRepository {

    private long nextId = 1L;

    private final Map<Long, BookEntry> bookEntryMap = new HashMap<>();

    private String normalizeTitle(String title) {
        if (title == null) return null;
        String normalized = Normalizer.normalize(title, Normalizer.Form.NFD); // Elimina tildes
        return normalized.replaceAll("\\p{M}", "").toLowerCase();
    }

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
        return this.bookEntryMap.replace(bookEntry.id(), bookEntry);
    }

    public BookEntry delete(BookEntry bookEntry) {
        this.bookEntryMap.remove(bookEntry.id(), bookEntry);
        return bookEntry;
    }

    public List<BookDto> getAll() {
        if (this.bookEntryMap.isEmpty()) return List.of();

        List<BookDto> bookDtoList = new ArrayList<>();
        for (BookEntry bookEntry : this.bookEntryMap.values()) {
            bookDtoList.add(BookMapper.toDto(bookEntry));
        }

        return bookDtoList;
    }
}

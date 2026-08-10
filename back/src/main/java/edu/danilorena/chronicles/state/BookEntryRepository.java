package edu.danilorena.chronicles.state;

import edu.danilorena.chronicles.display.dtos.BookDto;
import edu.danilorena.chronicles.logic.mappers.BookMapper;
import edu.danilorena.chronicles.logic.models.BookEntry;
import org.springframework.stereotype.Repository;

import java.text.Normalizer;
import java.util.*;

@Repository
public class BookEntryRepository {

    private final Map<String, BookEntry> bookEntryMap = new HashMap<>();


    private String normalizeTitle(String title) {
        if (title == null) return null;
        String normalized = Normalizer.normalize(title, Normalizer.Form.NFD); // Elimina tildes
        return normalized.replaceAll("\\p{M}", "").toLowerCase();
    }

    public Optional<BookEntry> getByTitle(String title) {
        return Optional.ofNullable(this.bookEntryMap.get(normalizeTitle(title)));
    }

    public BookEntry saveOrOverride(BookEntry bookEntry) {
        this.bookEntryMap.put(normalizeTitle(bookEntry.title()), bookEntry);
        return bookEntry;
    }

    public BookEntry delete(BookEntry bookEntry) {
        this.bookEntryMap.remove(normalizeTitle(bookEntry.title()), bookEntry);
        return bookEntry;
    }

    public List<BookDto> getAll() {
        if (this.bookEntryMap.isEmpty()) return null;

        List<BookDto> bookDtoList = new ArrayList<>();
        for (BookEntry bookEntry : this.bookEntryMap.values()) {
            bookDtoList.add(BookMapper.toDto(bookEntry));
        }

        return bookDtoList;
    }
}

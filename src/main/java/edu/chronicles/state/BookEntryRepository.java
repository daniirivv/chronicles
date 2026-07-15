package edu.chronicles.state;

import edu.chronicles.logic.models.BookEntry;

import java.util.Map;
import java.util.Optional;

public record BookEntryRepository(Map<String, BookEntry> bookEntryMap) {

    public Optional<BookEntry> getByTitle(String title) {
        return Optional.ofNullable(this.bookEntryMap.get(title));
    }

    public BookEntry saveOrOverride(BookEntry bookEntry) {
        this.bookEntryMap.put(bookEntry.getTitle(), bookEntry);
        return bookEntry;
    }

    public BookEntry delete(BookEntry bookEntry) {
        this.bookEntryMap.remove(bookEntry.getTitle(), bookEntry);
        return bookEntry;
    }
}

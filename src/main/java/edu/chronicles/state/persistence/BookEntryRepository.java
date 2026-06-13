package edu.chronicles.state.persistence;

import edu.chronicles.state.entries.BookEntry;

import java.util.Map;
import java.util.Optional;

public record BookEntryRepository(Map<String, BookEntry> bookEntryMap) {

    public Optional<BookEntry> getByTitle(String title) {
        return Optional.ofNullable(this.bookEntryMap.get(title));
    }

    public BookEntry save(BookEntry bookEntry) {
        return this.bookEntryMap.put(bookEntry.getBookTitle(), bookEntry);
    }
}

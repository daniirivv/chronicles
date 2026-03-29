package edu.chronicles.persistence;

import edu.chronicles.domain.models.BookEntry;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public record BookEntryRepository(Map<String, BookEntry> bookEntryMap) {

    public Optional<BookEntry> getByTitle(String title) {
        return Optional.ofNullable(this.bookEntryMap.get(title));
    }

    public Collection<BookEntry> getAll() {
        return this.bookEntryMap.values();
    }

    public BookEntry save(BookEntry bookEntry) {
        return this.bookEntryMap.put(bookEntry.getTitle(), bookEntry);
    }

    public BookEntry delete(String title) {
        return this.bookEntryMap.remove(title);
    }

    public boolean contains(String title) {
        return this.bookEntryMap.containsKey(title);
    }
}

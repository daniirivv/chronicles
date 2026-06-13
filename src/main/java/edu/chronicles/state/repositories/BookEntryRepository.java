package edu.chronicles.state.repositories;

import edu.chronicles.state.entries.BookEntry;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public record BookEntryRepository(Map<String, BookEntry> bookEntryMap) {

    public Optional<BookEntry> getByTitle(String title) {
        return Optional.ofNullable(this.bookEntryMap.get(title));
    }

    public BookEntry save(BookEntry bookEntry) {
        return this.bookEntryMap.put(bookEntry.getBookTitle(), bookEntry);
    }

    public List<BookEntry> findAll() {
        return List.copyOf(this.bookEntryMap.values());
    }

    public void delete(String title) {
        this.bookEntryMap.remove(title);
    }
}

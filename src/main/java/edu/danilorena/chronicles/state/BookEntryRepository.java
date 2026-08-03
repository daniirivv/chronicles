package edu.danilorena.chronicles.state;

import edu.danilorena.chronicles.logic.models.BookEntry;

import java.text.Normalizer;
import java.util.Map;
import java.util.Optional;

public record BookEntryRepository(Map<String, BookEntry> bookEntryMap) {

    private String normalizeTitle(String title) {
        if (title == null) return null;
        String normalized = Normalizer.normalize(title, Normalizer.Form.NFD); // Elimina tildes
        return normalized.replaceAll("\\p{M}", "").toLowerCase();
    }

    public Optional<BookEntry> getByTitle(String title) {
        return Optional.ofNullable(this.bookEntryMap.get(normalizeTitle(title)));
    }

    public BookEntry saveOrOverride(BookEntry bookEntry) {
        this.bookEntryMap.put(normalizeTitle(bookEntry.getTitle()), bookEntry);
        return bookEntry;
    }

    public BookEntry delete(BookEntry bookEntry) {
        this.bookEntryMap.remove(normalizeTitle(bookEntry.getTitle()), bookEntry);
        return bookEntry;
    }
}

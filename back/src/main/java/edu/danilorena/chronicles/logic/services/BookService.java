package edu.danilorena.chronicles.logic.services;

import edu.danilorena.chronicles.display.dtos.BookDto;
import edu.danilorena.chronicles.display.dtos.UpdateBookRequest;
import edu.danilorena.chronicles.logic.exceptions.EntryAlreadyExistedException;
import edu.danilorena.chronicles.logic.exceptions.EntryNotFoundException;
import edu.danilorena.chronicles.logic.mappers.BookMapper;
import edu.danilorena.chronicles.logic.models.BookEntry;
import edu.danilorena.chronicles.state.BookEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookEntryRepository bookEntryRepository;

    public BookService(BookEntryRepository bookEntryRepository) {
        this.bookEntryRepository = bookEntryRepository;
    }

    public BookDto createBookEntry(BookDto createDto)
            throws EntryAlreadyExistedException {

        String bookTitle = createDto.title();
        Optional<BookEntry> possibleCoincidence = this.bookEntryRepository.getByTitle(bookTitle);

        if (possibleCoincidence.isPresent())
            throw new EntryAlreadyExistedException("La entrada sobre " + bookTitle + " ya existe.");

        BookEntry toSave = BookMapper.toDomain(createDto);
        BookEntry saved = this.bookEntryRepository.saveOrOverride(toSave);
        return BookMapper.toDto(saved);
    }

    public Optional<List<BookDto>> retrieveAllEntries() {
        return Optional.ofNullable(this.bookEntryRepository.getAll());
    }

    public Optional<BookDto> retrieveBookEntry(String bookTitle) {
        Optional<BookEntry> possibleCoincidence = this.bookEntryRepository.getByTitle(bookTitle);
        return possibleCoincidence.map(BookMapper::toDto);
    }

    public BookDto updateBookEntry(String bookTitle, UpdateBookRequest patchData) {
        Optional<BookEntry> actualEntry = this.bookEntryRepository.getByTitle(bookTitle);
        return actualEntry.map(entry -> mergeEntry(entry, patchData))
                .orElseThrow();
    }

    private BookDto mergeEntry(BookEntry entry, UpdateBookRequest modifiedBookEntry) {
        return BookDto.builder()
                .author(modifiedBookEntry.author() != null ? modifiedBookEntry.author() : entry.author())
                .pages(modifiedBookEntry.pages() != null ? modifiedBookEntry.pages() : entry.pages())
                .releaseDate(modifiedBookEntry.releaseDate() != null ? modifiedBookEntry.releaseDate() : entry.releaseDate())
                .completed(modifiedBookEntry.completed() != null && entry.completed())
                .rating(modifiedBookEntry.rating() != null ? modifiedBookEntry.rating() : entry.getRatingValue())
                .build();
    }

    public BookDto deleteBookEntry(String bookTitle) {
        Optional<BookEntry> possibleCoincidence = this.bookEntryRepository.getByTitle(bookTitle);
        if (possibleCoincidence.isEmpty()){
            throw new EntryNotFoundException("La entrada sobre " + bookTitle + " no existe.");
        }

        BookEntry deleted = this.bookEntryRepository.delete(possibleCoincidence.get());
        return BookMapper.toDto(deleted);

    }

}
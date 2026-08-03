package edu.chronicles.logic.services;

import edu.chronicles.display.dtos.BookDto;
import edu.chronicles.logic.exceptions.EntryAlreadyExistedException;
import edu.chronicles.logic.exceptions.EntryNotFoundException;
import edu.chronicles.logic.mappers.BookMapper;
import edu.chronicles.logic.models.BookEntry;
import edu.chronicles.state.BookEntryRepository;

import java.util.Optional;

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

    public Optional<BookDto> retrieveBookEntry(String bookTitle) {
        Optional<BookEntry> possibleCoincidence = this.bookEntryRepository.getByTitle(bookTitle);
        return possibleCoincidence.map(BookMapper::toDto);
    }

    public BookDto updateBookEntry(BookDto actualBookEntry, BookDto modifiedBookEntry) {
        BookEntry mergedEntry = BookEntry.builder()
                .title(actualBookEntry.title())
                .author(modifiedBookEntry.author())
                .pages(modifiedBookEntry.pages())
                .releaseDate(modifiedBookEntry.releaseDate())
                .completed(modifiedBookEntry.completed())
                .rating(modifiedBookEntry.rating())
                .build();

        return BookMapper.toDto(this.bookEntryRepository.saveOrOverride(mergedEntry));
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
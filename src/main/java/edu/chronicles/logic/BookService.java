package edu.chronicles.logic;


import edu.chronicles.logic.exceptions.EntryAlreadyExistedException;
import edu.chronicles.state.entries.BookEntry;
import edu.chronicles.state.persistence.BookEntryRepository;
import edu.chronicles.display.dtos.BookCreateDto;
import edu.chronicles.display.dtos.BookResponseDto;

import java.util.Optional;

public class BookService {

    private final BookEntryRepository bookEntryRepository;

    public BookService(BookEntryRepository bookEntryRepository) {
        this.bookEntryRepository = bookEntryRepository;
    }

    public BookResponseDto createBookEntry(BookCreateDto createDto)
            throws IllegalArgumentException, EntryAlreadyExistedException {

        String title = createDto.title();
        Optional<BookEntry> possibleCoincidence = this.bookEntryRepository.getByTitle(title);

        if (possibleCoincidence.isPresent())
            throw new EntryAlreadyExistedException("La entrada sobre " + title + " ya existe.");

        BookEntry toSave = BookMapper.toDomain(createDto);
        BookEntry saved = this.bookEntryRepository.save(toSave);
        return BookMapper.toResponseDto(saved);
    }
}
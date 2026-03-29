package edu.chronicles.domain.services;

import edu.chronicles.domain.exceptions.EntryAlreadyExistedException;
import edu.chronicles.domain.mappers.BookMapper;
import edu.chronicles.domain.models.BookEntry;
import edu.chronicles.persistence.BookEntryRepository;
import edu.chronicles.presentation.dtos.BookCreateDto;

import java.util.List;
import java.util.Optional;

public class BookService {

    private BookEntryRepository bookEntryRepository;

    public BookEntry createBookEntry(BookCreateDto createDto) {
        if(this.bookEntryRepository.contains(createDto.title()))
            throw new EntryAlreadyExistedException("La entrada sobre " + createDto.title() + " ya existe.");

        BookEntry bookEntry;
        try {
            bookEntry = BookMapper.toDomain(createDto);
            this.bookEntryRepository.save(bookEntry);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        return bookEntry;
    }

    public Optional<BookEntry> getBookEntry(String title){
        return this.bookEntryRepository.getByTitle(title);
    }

    public List<BookEntry> getAll(){
        return List.copyOf(this.bookEntryRepository.getAll());
    }

    public BookEntry updateBookEntry(String title, BookUpdateDto updateDto){
        return null;
    }

    public boolean deleteBookEntry(BookEntry bookEntry){
        return false;
    }

}

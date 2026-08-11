package edu.danilorena.chronicles.logic.services;

import edu.danilorena.chronicles.display.dtos.BookRequestDto;
import edu.danilorena.chronicles.display.dtos.BookResponseDto;
import edu.danilorena.chronicles.logic.exceptions.EntryAlreadyExistsException;
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

    public BookResponseDto createBookEntry(BookRequestDto createEntryData)
            throws EntryAlreadyExistsException {

        searchTitleCoincidences(createEntryData);

        BookEntry toSave = BookMapper.toDomain(createEntryData);
        BookEntry saved = this.bookEntryRepository.save(toSave);
        return BookMapper.toResponseDto(saved);
    }

    private void searchTitleCoincidences(BookRequestDto createDto) {
        String bookTitle = createDto.title();
        Optional<BookEntry> possibleCoincidence = this.bookEntryRepository.findByTitle(bookTitle);

        if (possibleCoincidence.isPresent())
            throw new EntryAlreadyExistsException("La entrada sobre " + bookTitle + " ya existe.");
    }

    public List<BookResponseDto> retrieveAllEntries() {
        return this.bookEntryRepository.getAll();
    }

    public Optional<BookResponseDto> retrieveBookEntry(Long id) {
        Optional<BookEntry> possibleCoincidence = this.bookEntryRepository.findById(id);
        return possibleCoincidence.map(BookMapper::toResponseDto);
    }

    public List<BookResponseDto> retrieveBooksByAuthor(String authorName) {
        List<BookEntry> filteredEntries = this.bookEntryRepository.filterByAuthor(authorName);

        return filteredEntries
                .stream()
                .map(BookMapper::toResponseDto)
                .toList();
    }

    public BookResponseDto updateBookEntry(Long id, BookRequestDto patchData) {
        Optional<BookEntry> actualEntry = this.bookEntryRepository.findById(id);

        if (actualEntry.isEmpty()) {
            throw new EntryNotFoundException("La entrada no existe.");
        }

        BookEntry toSave = mergeEntry(actualEntry.get(), patchData);
        return BookMapper.toResponseDto(bookEntryRepository.update(toSave));
    }

    private BookEntry mergeEntry(BookEntry entry, BookRequestDto patchData) {
        return BookEntry.builder()
                .id(entry.id())
                .title(patchData.title() != null
                        ? patchData.title()
                        : entry.title())
                .author(patchData.author() != null
                        ? patchData.author()
                        : entry.author())
                .pages(patchData.pages() != null
                        ? patchData.pages()
                        : entry.pages())
                .releaseDate(patchData.releaseDate() != null
                        ? patchData.releaseDate()
                        : entry.releaseDate())
                .completed(patchData.completed() != null
                        ? patchData.completed()
                        : entry.completed())
                .rating(patchData.rating() != null
                        ? patchData.rating()
                        : entry.getRatingValue())
                .build();
    }

    public BookResponseDto deleteBookEntry(Long id) {
        Optional<BookEntry> possibleCoincidence = this.bookEntryRepository.findById(id);
        if (possibleCoincidence.isEmpty()){
            throw new EntryNotFoundException("La entrada no existe.");
        }

        BookEntry deleted = this.bookEntryRepository.delete(possibleCoincidence.get());
        return BookMapper.toResponseDto(deleted);

    }

}
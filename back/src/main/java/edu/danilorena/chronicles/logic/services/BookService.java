package edu.danilorena.chronicles.logic.services;

import edu.danilorena.chronicles.display.dtos.BookDto;
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

    public BookDto createBookEntry(BookDto createEntryData)
            throws EntryAlreadyExistsException {

        searchTitleCoincidences(createEntryData);

        BookEntry toSave = BookMapper.toDomain(createEntryData);
        BookEntry saved = this.bookEntryRepository.save(toSave);
        return BookMapper.toDto(saved);
    }

    private void searchTitleCoincidences(BookDto createDto) {
        String bookTitle = createDto.title();
        Optional<BookEntry> possibleCoincidence = this.bookEntryRepository.findByTitle(bookTitle);

        if (possibleCoincidence.isPresent())
            throw new EntryAlreadyExistsException("La entrada sobre " + bookTitle + " ya existe.");
    }

    public Optional<List<BookDto>> retrieveAllEntries() {
        return Optional.ofNullable(this.bookEntryRepository.getAll());
    }

    public Optional<BookDto> retrieveBookEntry(Long id) {
        Optional<BookEntry> possibleCoincidence = this.bookEntryRepository.findById(id);
        return possibleCoincidence.map(BookMapper::toDto);
    }

    public BookDto updateBookEntry(Long id, BookDto patchData) {
        Optional<BookEntry> actualEntry = this.bookEntryRepository.findById(id);

        if (actualEntry.isEmpty()) {
            throw new EntryNotFoundException("La entrada no existe.");
        }

        BookEntry toSave = mergeEntry(actualEntry.get(), patchData);
        return BookMapper.toDto(bookEntryRepository.update(toSave));
    }

    private BookEntry mergeEntry(BookEntry entry, BookDto patchData) {
        return BookEntry.builder()
                .author(patchData.author() != null
                        ? patchData.author()
                        : entry.author()
                )
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

    public BookDto deleteBookEntry(Long id) {
        Optional<BookEntry> possibleCoincidence = this.bookEntryRepository.findById(id);
        if (possibleCoincidence.isEmpty()){
            throw new EntryNotFoundException("La entrada no existe.");
        }

        BookEntry deleted = this.bookEntryRepository.delete(possibleCoincidence.get());
        return BookMapper.toDto(deleted);

    }

}
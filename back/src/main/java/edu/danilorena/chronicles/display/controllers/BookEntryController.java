package edu.danilorena.chronicles.display.controllers;

import edu.danilorena.chronicles.display.dtos.BookRequestDto;
import edu.danilorena.chronicles.display.dtos.BookResponseDto;
import edu.danilorena.chronicles.logic.exceptions.EntryAlreadyExistsException;
import edu.danilorena.chronicles.logic.exceptions.EntryNotFoundException;
import edu.danilorena.chronicles.logic.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookEntryController {

    private final BookService service;

    public BookEntryController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BookResponseDto> createBookEntry(@RequestBody BookRequestDto bookData) {
        try {
            BookResponseDto createdBook = service.createBookEntry(bookData);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(createdBook);

        } catch (IllegalArgumentException | EntryAlreadyExistsException e) {
            return ResponseEntity.
                    badRequest().
                    build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<BookResponseDto>> getAllBookEntriesUseCase() {
        List<BookResponseDto> bookEntries = this.service.retrieveAllEntries();
        if (bookEntries.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(bookEntries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> retrieveBookEntryUseCase(@PathVariable Long id) {
        Optional<BookResponseDto> retrieved = this.service.retrieveBookEntry(id);

        return retrieved.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity
                .notFound()
                .build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BookResponseDto> updateBookEntryUseCase(
            @PathVariable Long id,
            @RequestBody BookRequestDto patchData
    ) {
        try{
            return ResponseEntity
                    .ok(this.service.updateBookEntry(id, patchData));
        } catch (EntryNotFoundException e) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BookResponseDto> deleteBookEntryUseCase(@PathVariable Long id) {
        try{
            BookResponseDto deleted = this.service.deleteBookEntry(id);

            return ResponseEntity
                    .ok(deleted);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (EntryNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}

package edu.danilorena.chronicles.display.controllers;

import edu.danilorena.chronicles.display.dtos.BookDto;
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
    public ResponseEntity<BookDto> createBookEntry(@RequestBody BookDto bookData) {
        try {
            BookDto createdBook = service.createBookEntry(bookData);

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
    public ResponseEntity<List<BookDto>> getAllBookEntriesUseCase() {
        return ResponseEntity
                .of(this.service.retrieveAllEntries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> retrieveBookEntryUseCase(@PathVariable Long id) {
        Optional<BookDto> retrieved = this.service.retrieveBookEntry(id);

        return retrieved.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity
                .notFound()
                .build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BookDto> updateBookEntryUseCase(
            @PathVariable Long id,
            @RequestBody BookDto patchData
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
    public ResponseEntity<BookDto> deleteBookEntryUseCase(@PathVariable Long id) {
        try{
            BookDto deleted = this.service.deleteBookEntry(id);

            return ResponseEntity
                    .ok(deleted);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (EntryNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}

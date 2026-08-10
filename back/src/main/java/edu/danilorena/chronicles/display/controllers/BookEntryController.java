package edu.danilorena.chronicles.display.controllers;

import edu.danilorena.chronicles.display.dtos.BookDto;
import edu.danilorena.chronicles.display.dtos.UpdateBookRequest;
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

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<BookDto>> getAllBookEntriesUseCase() {
        return ResponseEntity
                .of(this.service.retrieveAllEntries());
    }

    @GetMapping("/{bookTitle}")
    public ResponseEntity<BookDto> retrieveBookEntryUseCase(@PathVariable String bookTitle) {
        Optional<BookDto> retrieved = this.service.retrieveBookEntry(bookTitle);

        return retrieved.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity
                .notFound()
                .build());
    }

    @PatchMapping("/{bookTitle}")
    public ResponseEntity<BookDto> updateBookEntryUseCase(@PathVariable String bookTitle, @RequestBody UpdateBookRequest patchData) {
        try{
            return ResponseEntity
                    .ok(this.service.updateBookEntry(bookTitle, patchData));
        } catch (EntryNotFoundException e) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }

    @DeleteMapping("{bookTitle}")
    public ResponseEntity<Void> deleteBookEntryUseCase(@PathVariable String bookTitle) {
        try{
            this.service.deleteBookEntry(bookTitle);

            return ResponseEntity
                    .ok()
                    .build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (EntryNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}

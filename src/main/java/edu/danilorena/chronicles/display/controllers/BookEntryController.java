package edu.danilorena.chronicles.display.controllers;

import edu.danilorena.chronicles.display.dtos.BookDto;
import edu.danilorena.chronicles.logic.exceptions.EntryNotFoundException;
import edu.danilorena.chronicles.logic.services.BookService;
import edu.danilorena.chronicles.display.views.CLI;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{bookTitle}")
    private ResponseEntity<BookDto> retrieveBookEntryUseCase(@PathVariable String bookTitle) {
        Optional<BookDto> retrieved = this.service.retrieveBookEntry(bookTitle);

        return retrieved.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity
                .notFound()
                .build());
    }

    @PatchMapping()
    private void updateBookEntryUseCase() {
        try{
            String bookTitle = view.askForInput("Introduce el título de la entrada que quieres modificar: ");
            Optional<BookDto> toModify = this.service.retrieveBookEntry(bookTitle);
            if (toModify.isEmpty()) {
                throw new EntryNotFoundException(bookTitle);
            }
            BookDto actualBookEntry = toModify.get();
            view.printBookEntry(actualBookEntry);
            view.showSuccess("Añade los nuevos valores a la entrada: ");
            BookDto modifiedBookEntry = view.askForUpdatedBookData();
            BookDto updatedEntry = service.updateBookEntry(actualBookEntry, modifiedBookEntry);
            view.showSuccess("Entrada modificada correctamente: ");
            view.printBookEntry(updatedEntry);

        } catch (EntryNotFoundException e) {
            view.showError(e.getMessage());
        }
    }

    @DeleteMapping("{bookTitle}")
    private ResponseEntity<Void> deleteBookEntryUseCase(@PathVariable String bookTitle) {
        try{
            return ResponseEntity
                    .ok()
                    .build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}

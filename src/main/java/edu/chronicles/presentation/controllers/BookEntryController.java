package edu.chronicles.presentation.controllers;

import edu.chronicles.domain.mappers.BookMapper;
import edu.chronicles.domain.models.BookEntry;
import edu.chronicles.domain.services.BookService;
import edu.chronicles.presentation.dtos.BookCreateDto;
import edu.chronicles.presentation.dtos.BookResponseDto;

import java.time.Year;
import java.util.Map;

public class BookEntryController {

    private final BookService bookService;

    public BookEntryController(BookService bookService) {
        this.bookService = bookService;
    }

    public String createBookEntryUseCase(Map<String, Object> params) {
        try{
            String title = params.get("title").toString();
            String author = params.get("author").toString();
            int pages = Integer.parseInt(params.get("pages").toString());
            Year releaseYear = Year.of(Integer.parseInt(params.get("releaseYear").toString()));
            boolean completed = params.get("completed").toString().equals("y");
            int rating = Integer.parseInt(params.get("rating").toString());

            if (title == null || title.isBlank())
                throw new IllegalArgumentException("El título del libro no puede estar vacío.");

            BookCreateDto toCreate = new BookCreateDto(title, author, pages, releaseYear, completed, rating);
            BookResponseDto created = this.bookService.createBookEntry(toCreate);
            return "Entrada sobre " + created.title() + " creada correctamente.\n";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

}

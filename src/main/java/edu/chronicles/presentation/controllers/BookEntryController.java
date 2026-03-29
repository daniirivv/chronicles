package edu.chronicles.presentation.controllers;

import edu.chronicles.domain.services.BookService;
import edu.chronicles.presentation.dtos.BookCreateDto;
import edu.chronicles.presentation.dtos.BookResponseDto;
import edu.chronicles.presentation.views.CLI;

import java.time.Year;
import java.util.Map;
import java.util.Optional;

public class BookEntryController {

    private final CLI view;
    private final BookService service;

    public BookEntryController(CLI view, BookService service) {
        this.view = view;
        this.service = service;
    }

    public void run(){
        view.welcome();

        boolean exit = false;
        do{
            view.showMenu();
            int option = view.readOption();
            switch (option){
                case 1 -> handleCreate();
                case 0 -> exit = true;
                default -> throw new IllegalArgumentException("Esa opción no es válida");
            }
        } while (!exit);
    }

    private void handleCreate() {
        String title = view.askForParam("Introduce el título del libro: ");
        // To-do: resto de parámetros
        createBookEntryUseCase(Map.of("title", title));
    }

    private void createBookEntryUseCase(Map<String, Object> params) {
        try{
            String title = (String) params.get("title");
            String author = (String) params.get("author");
            // To-do: gestionar esto
            Integer pages = null;
            Year releaseYear = null;
            boolean completed = params.get("completed").toString().equals("y");
            int rating = Integer.parseInt(params.get("rating").toString());

            if (title == null || title.isBlank())
                throw new IllegalArgumentException("El título del libro no puede estar vacío.");

            BookCreateDto toCreate = new BookCreateDto(title, author, pages, releaseYear, completed, rating);
            BookResponseDto created = this.service.createBookEntry(toCreate);
            view.showSuccessfullOutput("Entrada sobre " + created.title() + " creada correctamente.\n");
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
        }
    }

}

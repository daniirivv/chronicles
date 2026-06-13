package edu.chronicles.presentation.controllers;

import edu.chronicles.domain.services.BookService;
import edu.chronicles.presentation.dtos.BookCreateDto;
import edu.chronicles.presentation.dtos.BookResponseDto;
import edu.chronicles.presentation.views.CLI;

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
                case 1 -> createBookEntryUseCase();
                case 0 -> exit = true;
                default -> throw new IllegalArgumentException("Esa opción no es válida");
            }
        } while (!exit);
    }

    private void createBookEntryUseCase() {
        try{
            BookCreateDto bookData = view.askForBookData();
            BookResponseDto created = this.service.createBookEntry(bookData);
            view.showSuccessfullOutput("Entrada sobre " + created.title() + " creada correctamente.\n");
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
        }
    }

}

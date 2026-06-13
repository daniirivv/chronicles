package edu.chronicles.display.controllers;

import edu.chronicles.logic.BookService;
import edu.chronicles.display.dtos.BookCreateDto;
import edu.chronicles.display.dtos.BookResponseDto;
import edu.chronicles.display.views.CLI;

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

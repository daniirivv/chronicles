package edu.chronicles.display.controllers;

import edu.chronicles.display.dtos.BookDto;
import edu.chronicles.logic.exceptions.EntryNotFoundException;
import edu.chronicles.logic.services.BookService;
import edu.chronicles.display.views.CLI;

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
                case 1 -> createBookEntryUseCase();
                case 2 -> retrieveBookEntryUseCase();
                case 3 -> updateBookEntryUseCase();
                case 4 -> deleteBookEntryUseCase();
                case 0 -> exit = true;
                default -> throw new IllegalArgumentException("Opción no válida");
            }
        } while (!exit);
    }

    private void createBookEntryUseCase() {
        try{
            BookDto bookData = view.askForBookCreationData();
            BookDto created = this.service.createBookEntry(bookData);
            view.showSuccess("Entrada sobre " + created.title() + " creada correctamente.");
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
        }
    }

    private void retrieveBookEntryUseCase() {
        String bookTitle = view.askForInput("Introduce el título de la entrada que quieres leer: ");
        Optional<BookDto> retrieved = this.service.retrieveBookEntry(bookTitle);

        if(retrieved.isEmpty()) {
            view.showError("No se han encontrado coincidencias.");
            return;
        }

        BookDto bookResponse = retrieved.get();
        view.showSuccess("Entrada sobre " + bookResponse.title() + " recuperada correctamente.");
        view.printBookEntry(bookResponse);
    }

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

    private void deleteBookEntryUseCase() {
        try{
            String bookTitle = view.askForInput("Introduce el título del libro cuya entrada quieres eliminar: ");
            BookDto deleted = this.service.deleteBookEntry(bookTitle);
            view.showSuccess("Entrada sobre " + deleted.title() + " eliminada correctamente.");
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
        }
    }

}

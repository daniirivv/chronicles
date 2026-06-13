package edu.chronicles;

import edu.chronicles.domain.services.BookService;
import edu.chronicles.persistence.BookEntryRepository;
import edu.chronicles.presentation.controllers.BookEntryController;
import edu.chronicles.presentation.views.CLI;

import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        BookEntryRepository repository = new BookEntryRepository(new HashMap<>());
        BookService service = new BookService(repository);
        CLI view = new CLI();

        BookEntryController controller = new BookEntryController(view, service);

        controller.run();
    }
}
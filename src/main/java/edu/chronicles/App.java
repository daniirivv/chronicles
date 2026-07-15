package edu.chronicles;

import edu.chronicles.logic.services.BookService;
import edu.chronicles.state.BookEntryRepository;
import edu.chronicles.display.controllers.BookEntryController;
import edu.chronicles.display.views.CLI;

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
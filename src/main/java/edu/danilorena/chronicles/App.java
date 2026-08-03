package edu.danilorena.chronicles;

import edu.danilorena.chronicles.logic.services.BookService;
import edu.danilorena.chronicles.state.BookEntryRepository;
import edu.danilorena.chronicles.display.controllers.BookEntryController;
import edu.danilorena.chronicles.display.views.CLI;

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
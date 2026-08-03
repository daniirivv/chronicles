package edu.chronicles;

import edu.chronicles.back.logic.services.BookService;
import edu.chronicles.back.state.BookEntryRepository;
import edu.chronicles.back.display.controllers.BookEntryController;
import edu.chronicles.back.display.views.CLI;

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
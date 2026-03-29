package edu.chronicles;

import edu.chronicles.domain.services.BookService;
import edu.chronicles.persistence.BookEntryRepository;
import edu.chronicles.presentation.controllers.BookEntryController;
import edu.chronicles.presentation.views.CLI;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        // 1. Montamos las piezas
        BookEntryRepository repository = new BookEntryRepository(new HashMap<>());
        BookService service = new BookService(repository);
        CLI view = new CLI();

        // 2. Creamos el director y le pasamos sus herramientas
        BookEntryController controller = new BookEntryController(view, service);

        // 3. ¡Empieza la función!
        controller.run();
    }
}
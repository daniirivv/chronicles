package entries;

import edu.chronicles.model.entries.FilmEntry;
import org.junit.jupiter.api.BeforeEach;

public class FilmEntryTest {
    private static final String FILM_NAME = "La Sociedad de la Nieve";

    private FilmEntry filmEntry;

    @BeforeEach
    void initializeFilm() { filmEntry = new FilmEntry(FILM_NAME); }

    // TODO: No sé qué testear xd

}

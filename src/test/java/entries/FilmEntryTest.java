package entries;

import edu.chronicles.model.entries.FilmEntry;
import edu.chronicles.model.value_objects.UserRating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FilmEntryTest {
    private static final String FILM_NAME = "La Sociedad de la Nieve";

    private FilmEntry filmEntry;

    @BeforeEach
    void initializeFilm() { filmEntry = new FilmEntry(FILM_NAME); }

    @Test
    void shouldReturnErrorWhenInvalidIMDBRating() {
        assertThrows(InvalidIMDBRatingException.class, () -> filmEntry.setImdbRating(12.3F));
    }

}

package entries;

import edu.chronicles.model.entries.FilmEntry;
import edu.chronicles.model.exceptions.InvalidIMDBRatingException;
import edu.chronicles.model.value_objects.IMDBRating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FilmEntryTest {
    private static final String FILM_NAME = "La Sociedad de la Nieve";

    private FilmEntry filmEntry;

    @BeforeEach
    void initializeFilm() { filmEntry = new FilmEntry(FILM_NAME); }

    @Test
    void shouldReturnErrorWhenInvalidHighIMDBRating() {
        assertThrows(InvalidIMDBRatingException.class, () -> filmEntry.setImdbRating(IMDBRating.of(12.3F)));
    }

    @Test
    void shouldReturnErrorWhenInvalidLowIMDBRating() {
        assertThrows(InvalidIMDBRatingException.class, () -> filmEntry.setImdbRating(IMDBRating.of(-0.3F)));
    }

}

package entries;

import edu.chronicles.model.value_objects.Rating;
import edu.chronicles.model.exceptions.InvalidRatingException;
import edu.chronicles.model.entries.TVShowEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class EntryTest {
    private static final String SHOW_TITLE = "La Casa de Papel";

    private TVShowEntry tvShowEntry;

    @BeforeEach
    void initializeShow(){
        tvShowEntry = new TVShowEntry(SHOW_TITLE);
    }

    @Test
    void rejectsRatingBelowRange() {
        assertThrows(InvalidRatingException.class, () -> tvShowEntry.rate(Rating.of(-1)));
    }

    @Test
    void rejectsRatingAboveRange() {
        assertThrows(InvalidRatingException.class, () -> tvShowEntry.rate(Rating.of(6)));
    }
}

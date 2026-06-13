package entries;

import edu.chronicles.logic.exceptions.InvalidRatingException;
import edu.chronicles.state.entries.TVShowEntry;
import edu.chronicles.state.value_objects.UserRating;
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
        assertThrows(InvalidRatingException.class, () -> tvShowEntry.rate(UserRating.of(-1)));
    }

    @Test
    void rejectsRatingAboveRange() {
        assertThrows(InvalidRatingException.class, () -> tvShowEntry.rate(edu.chronicles.state.value_objects.UserRating.of(6)));
    }
}

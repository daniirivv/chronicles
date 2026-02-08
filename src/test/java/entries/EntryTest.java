package entries;

import edu.chronicles.model.exceptions.InvalidRatingException;
import edu.chronicles.model.entries.TVSeriesEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class EntryTest {
    private static final String SHOW_TITLE = "La Casa de Papel";
    private static final String SHOW_CREATOR = "Álex Pina";

    private TVSeriesEntry tvSeriesEntry;

    @BeforeEach
    void initializeShow(){
        tvSeriesEntry = new TVSeriesEntry(SHOW_TITLE);
    }

    @Test
    void rejectsRatingBelowRange() {
        assertThrows(InvalidRatingException.class, () -> tvSeriesEntry.setRating(-1));
    }

    @Test
    void rejectsRatingAboveRange() {
        assertThrows(InvalidRatingException.class, () -> tvSeriesEntry.setRating(6));
    }
}

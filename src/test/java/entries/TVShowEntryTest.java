package entries;

import edu.chronicles.model.entries.TVShowEntry;
import edu.chronicles.model.exceptions.InvalidStateException;
import edu.chronicles.model.value_objects.UserRating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TVShowEntryTest {

    private static final String SHOW_TITLE = "Stranger Things";

    private TVShowEntry tvShowEntry;

    @BeforeEach
    void initializeShow(){
        tvShowEntry = new TVShowEntry(SHOW_TITLE);
    }

    @Test
    void shouldReturnErrorWhenRatingWithoutCompletion() {
        assertThrows(InvalidStateException.class, () -> tvShowEntry.rate(UserRating.of(3)));
    }

}

package entries;

import edu.chronicles.model.enums.CompletionState;
import edu.chronicles.model.value_objects.Rating;
import edu.chronicles.model.entries.BookEntry;
import edu.chronicles.model.exceptions.InvalidNumberOfPagesException;
import edu.chronicles.model.exceptions.InvalidStateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookEntryTest {
    private static final String BOOK_TITLE = "Atomic Habits";

    private BookEntry bookEntry;

    @BeforeEach
    void initializeBook(){
        bookEntry = new BookEntry(BOOK_TITLE);
    }

    @Test
    void rejectsInvalidPageNumbers() {
        assertThrows(InvalidNumberOfPagesException.class, () -> bookEntry.setPages(-1));
    }

    @Test
    void correctInitialCompletionState() {
        assertEquals(CompletionState.PLANEADO, bookEntry.getState());
    }

    @Test
    void shouldReturnErrorWhenRatingWithoutCompletion() {
        assertThrows(InvalidStateException.class, () -> bookEntry.rate(Rating.of(3)));
    }
}

package entries;

import edu.chronicles.state.enums.CompletionState;
import edu.chronicles.state.entries.BookEntry;
import edu.chronicles.logic.exceptions.InvalidNumberOfPagesException;
import edu.chronicles.logic.exceptions.InvalidStateException;
import edu.chronicles.state.value_objects.UserRating;
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
        assertThrows(InvalidStateException.class, () -> bookEntry.rate(UserRating.of(3)));
    }
}

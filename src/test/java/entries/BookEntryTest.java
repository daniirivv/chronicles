package entries;

import edu.chronicles.model.entries.BookEntry;
import edu.chronicles.model.exceptions.InvalidNumberOfPagesException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookEntryTest {
    private static final String BOOK_TITLE = "Atomic Habits";
    private static final String BOOK_AUTHOR = "James Clear";

    private BookEntry bookEntry;

    @BeforeEach
    void initializeBook(){
        bookEntry = new BookEntry(BOOK_TITLE);
    }

    @Test
    void rejectsInvalidPageNumbers() {
        assertThrows(InvalidNumberOfPagesException.class, () -> bookEntry.setPages(-1));
    }

}

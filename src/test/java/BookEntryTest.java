import edu.chronicles.model.BookEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookEntryTest {

    private static final String BOOK_TITLE = "Atomic Habits";
    private static final String BOOK_AUTHOR = "James Clear";
    private static final int BOOK_PAGES = 328;

    private BookEntry bookEntry;

    @BeforeEach
    void initializeBook(){
        bookEntry = new BookEntry(BOOK_TITLE, BOOK_AUTHOR, BOOK_PAGES);
    }

    @Test
    public void bookHasCorrectAttributesWhenCreated() {
        assertEquals(BOOK_TITLE, bookEntry.getName());
        assertEquals(BOOK_AUTHOR, bookEntry.getAuthor());
        assertEquals(BOOK_PAGES, bookEntry.getNumberOfPages());
    }

    @Test
    public void bookHasCorrectAttributesWhenAllAdded() {
        assertEquals(BOOK_TITLE, bookEntry.getName());
        assertEquals(BOOK_AUTHOR, bookEntry.getAuthor());
        assertEquals(2, bookEntry.getRating());
        assertEquals(2025, bookEntry.getYearRead());
        assertEquals(BOOK_PAGES, bookEntry.getNumberOfPages());
    }

    @Test
    public void bookHasCorrectAttributesWhenAddedLater() {
        bookEntry.setRating(2);
        bookEntry.setYearRead(2025);

        assertEquals(2, bookEntry.getRating());
        assertEquals(2025, bookEntry.getYearRead());
    }
}

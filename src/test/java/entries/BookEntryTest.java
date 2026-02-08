package entries;

import edu.chronicles.model.entries.BookEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookEntryTest {

    private static final String BOOK_TITLE = "Atomic Habits";

    private BookEntry bookEntry;

    @BeforeEach
    void initializeBook(){
        bookEntry = new BookEntry(BOOK_TITLE);
    }

    @Test
    void bookHasCorrectAttributesWhenCreated() {
        assertEquals(BOOK_TITLE, bookEntry.getName());
        assertEquals(BOOK_AUTHOR, bookEntry.getAuthor());
        assertEquals(BOOK_PAGES, bookEntry.getNumberOfPages());
    }

    @Test
    void bookHasCorrectAttributesWhenAllAdded() {
        assertEquals(BOOK_TITLE, bookEntry.getName());
        assertEquals(BOOK_AUTHOR, bookEntry.getAuthor());
        assertEquals(2, bookEntry.getRating());
        assertEquals(2025, bookEntry.getYearRead());
        assertEquals(BOOK_PAGES, bookEntry.getNumberOfPages());
    }

    @Test
    void bookHasCorrectAttributesWhenAddedLater() {
        bookEntry.setRating(2);
        bookEntry.setYearRead(2025);

        assertEquals(2, bookEntry.getRating());
        assertEquals(2025, bookEntry.getYearRead());
    }
}

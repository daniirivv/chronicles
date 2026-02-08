import edu.chronicles.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    private static final String BOOK_TITLE = "Atomic Habits";
    private static final String BOOK_AUTHOR = "James Clear";
    private static final int BOOK_PAGES = 328;

    private Book book;

    @BeforeEach
    void initializeBook(){
        book = new Book(BOOK_TITLE, BOOK_AUTHOR, BOOK_PAGES);
    }

    @Test
    public void bookHasCorrectAttributesWhenCreated() {
        assertEquals(BOOK_TITLE, book.getName());
        assertEquals(BOOK_AUTHOR, book.getAuthor());
        assertEquals(BOOK_PAGES, book.getNumberOfPages());
    }

    @Test
    public void bookHasCorrectAttributesWhenAllAdded() {
        assertEquals(BOOK_TITLE, book.getName());
        assertEquals(BOOK_AUTHOR, book.getAuthor());
        assertEquals(2, book.getRating());
        assertEquals(2025, book.getYearRead());
        assertEquals(BOOK_PAGES, book.getNumberOfPages());
    }

    @Test
    public void bookHasCorrectAttributesWhenAddedLater() {
        book.setRating(2);
        book.setYearRead(2025);

        assertEquals(2, book.getRating());
        assertEquals(2025, book.getYearRead());
    }
}

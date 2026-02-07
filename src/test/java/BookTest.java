import edu.chronicles.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    @Test
    public void bookHasCorrectAttributes() {
        Book book = new Book("Hábitos Atómicos", "James Clear", 2, 2025);

        assertEquals("Hábitos Atómicos", book.getName());
        assertEquals("James Clear", book.getAuthor());
        assertEquals(2, book.getPunctuation());
        assertEquals(2025, book.getYearLastRead());
    }
}

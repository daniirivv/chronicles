import edu.chronicles.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {
    @Test
    public void bookHasCorrectAttributesWhenCreated() {
        Book book = new Book("Hábitos Atómicos", "James Clear", 328);

        assertEquals("Hábitos Atómicos", book.getName());
        assertEquals("James Clear", book.getAuthor());
        assertEquals(328, book.getNumberOfPages());
    }

    @Test
    public void bookHasCorrectAttributesWhenAllAdded() {
        Book book = new Book("Hábitos Atómicos", "James Clear", 2, 2025, 328);

        assertEquals("Hábitos Atómicos", book.getName());
        assertEquals("James Clear", book.getAuthor());
        assertEquals(2, book.getRating());
        assertEquals(2025, book.getYearRead());
        assertEquals(328, book.getNumberOfPages());
    }

    @Test
    public void bookHasCorrectAttributesWhenAddedLater() {
        Book book = new Book("Hábitos Atómicos", "James Clear", 328);

        book.setRating(2);
        book.setYearRead(2025);

        assertEquals(2, book.getRating());
        assertEquals(2025, book.getYearRead());
    }
}

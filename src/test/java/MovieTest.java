import edu.chronicles.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {

    @Test
    public void movieHasCorrectAttributesWhenCreated() {
        Movie movie = new Book("Inception", "Christopher Nolan");

        assertEquals("Inception", movie.getName());
        assertEquals("Christopher Nolan", movie.getDirector());
    }
}

import edu.chronicles.Book;
import edu.chronicles.Movie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {

    @Test
    public void movieHasCorrectAttributesWhenCreated() {
        Movie movie = new Movie("Inception", "Christopher Nolan");

        assertEquals("Inception", movie.getName());
        assertEquals("Christopher Nolan", movie.getDirector());
    }

    @Test
    public void movieHasCorrectAttributesWhenAllAdded() {
        Movie movie = new Movie("Inception", "Christopher Nolan", 3, 2020);

        assertEquals("Inception", movie.getName());
        assertEquals("Christopher Nolan", movie.getDirector());
        assertEquals(3, movie.getPunctuation());
        assertEquals(2020, movie.getYearSeen());
    }

    @Test
    public void movieHasCorrectAttributesWhenAddedLater() {
        Movie movie = new Movie("Inception", "Christopher Nolan");

        movie.setPunctuation(3);
        movie.setYearSeen(2020);

        assertEquals(3, movie.getPunctuation());
        assertEquals(2020, movie.getYearSeen());
    }
}

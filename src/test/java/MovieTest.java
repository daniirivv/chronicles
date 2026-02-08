import edu.chronicles.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {

    private static final String MOVIE_TITLE = "Inception";
    private static final String MOVIE_DIRECTOR = "Christopher Nolan";

    private Movie movie;

    @BeforeEach
    void initializeMovie(){
        movie = new Movie(MOVIE_TITLE, MOVIE_DIRECTOR);
    }

    @Test
    public void givenACreatedMovie_whenAccessingItsAttributes_shouldReturnCorrectAttributes() {
        assertEquals(MOVIE_TITLE, movie.getName());
        assertEquals(MOVIE_DIRECTOR, movie.getDirector());
    }

    @Test
    public void movieHasCorrectAttributesWhenAllAdded() {
        assertEquals(MOVIE_TITLE, movie.getName());
        assertEquals(MOVIE_DIRECTOR, movie.getDirector());
        assertEquals(3, movie.getRating());
        assertEquals(2020, movie.getYearSeen());
    }

    @Test
    public void movieHasCorrectAttributesWhenAddedLater() {
        movie.setRating(3);
        movie.setYearSeen(2020);

        assertEquals(3, movie.getRating());
        assertEquals(2020, movie.getYearSeen());
    }
}

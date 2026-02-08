import edu.chronicles.model.entries.MovieEntry;
import edu.chronicles.model.VODPlatform;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieEntryTest {

    private static final String MOVIE_TITLE = "Inception";
    private static final String MOVIE_DIRECTOR = "Christopher Nolan";

    private MovieEntry movieEntry;

    @BeforeEach
    void initializeMovie(){
        movieEntry = new MovieEntry(MOVIE_TITLE, MOVIE_DIRECTOR);
    }

    @Test
    public void givenACreatedMovie_whenAccessingItsAttributes_shouldReturnCorrectAttributes() {
        VODPlatform moviePlatform = VODPlatform.NETFLIX;

        assertEquals(MOVIE_TITLE, movieEntry.getName());
        assertEquals(MOVIE_DIRECTOR, movieEntry.getDirector());
        assertEquals(moviePlatform, movieEntry.getPlatform());
    }

    @Test
    public void movieHasCorrectAttributesWhenAllAdded() {
        assertEquals(MOVIE_TITLE, movieEntry.getName());
        assertEquals(MOVIE_DIRECTOR, movieEntry.getDirector());
        assertEquals(3, movieEntry.getRating());
        assertEquals(2020, movieEntry.getYearSeen());
    }

    @Test
    public void movieHasCorrectAttributesWhenAddedLater() {
        movieEntry.setRating(3);
        movieEntry.setYearSeen(2020);

        assertEquals(3, movieEntry.getRating());
        assertEquals(2020, movieEntry.getYearSeen());
    }
}

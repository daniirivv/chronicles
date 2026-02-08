package entries;

import edu.chronicles.model.entries.FilmEntry;
import edu.chronicles.model.VODPlatform;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilmEntryTest {

    private static final String MOVIE_TITLE = "Inception";
    private static final String MOVIE_DIRECTOR = "Christopher Nolan";

    private FilmEntry filmEntry;

    @BeforeEach
    void initializeMovie(){
        filmEntry = new FilmEntry(MOVIE_TITLE);
    }

    @Test
    void givenACreatedMovie_whenAccessingItsAttributes_shouldReturnCorrectAttributes() {
        VODPlatform moviePlatform = VODPlatform.NETFLIX;

        assertEquals(MOVIE_TITLE, filmEntry.getName());
        assertEquals(MOVIE_DIRECTOR, filmEntry.getDirector());
        assertEquals(moviePlatform, filmEntry.getPlatform());
    }

    @Test
    void movieHasCorrectAttributesWhenAllAdded() {
        assertEquals(MOVIE_TITLE, filmEntry.getName());
        assertEquals(MOVIE_DIRECTOR, filmEntry.getDirector());
        assertEquals(3, filmEntry.getRating());
        assertEquals(2020, filmEntry.getYearSeen());
    }

    @Test
    void movieHasCorrectAttributesWhenAddedLater() {
        filmEntry.setRating(3);
        filmEntry.setYearSeen(2020);

        assertEquals(3, filmEntry.getRating());
        assertEquals(2020, filmEntry.getYearSeen());
    }
}

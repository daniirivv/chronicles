import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TVShowTest {

    private static final String SHOW_TITLE = "La Casa de Papel";
    private static final String SHOW_CREATOR = "Álex Pina";

    private TVShow tvShow;

    @BeforeEach
    void initializeShow(){
        tvShow = new TVShow(SHOW_TITLE, SHOW_CREATOR);
    }

    @Test
    void givenTVShowEntryParams_whenCreateNewEntry_shouldCreateCorrectEntry(){
        assertEquals(SHOW_TITLE, tvShow.getTitle());
        assertEquals(SHOW_CREATOR, tvShow.getCreator());
    }
}

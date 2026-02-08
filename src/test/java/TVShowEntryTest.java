import edu.chronicles.model.entries.TVShowEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TVShowEntryTest {

    private static final String SHOW_TITLE = "La Casa de Papel";
    private static final String SHOW_CREATOR = "Álex Pina";

    private TVShowEntry tvShowEntry;

    @BeforeEach
    void initializeShow(){
        tvShowEntry = new TVShowEntry(SHOW_TITLE, SHOW_CREATOR);
    }

    @Test
    void givenTVShowEntryParams_whenCreateNewEntry_shouldCreateCorrectEntry(){
        assertEquals(SHOW_TITLE, tvShowEntry.getTitle());
        assertEquals(SHOW_CREATOR, tvShowEntry.getCreator());
    }
}

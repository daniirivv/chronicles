package entries;

import edu.chronicles.model.entries.TVSeriesEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TVSeriesEntryTest {

    private static final String SHOW_TITLE = "La Casa de Papel";
    private static final String SHOW_CREATOR = "Álex Pina";

    private TVSeriesEntry tvSeriesEntry;

    @BeforeEach
    void initializeShow(){
        tvSeriesEntry = new TVSeriesEntry(SHOW_TITLE);
    }

    @Test
    void givenTVShowEntryParams_whenCreateNewEntry_shouldCreateCorrectEntry(){
        assertEquals(SHOW_TITLE, tvSeriesEntry.getTitle());
        assertEquals(SHOW_CREATOR, tvSeriesEntry.getCreator());
    }
}

package entries;

import edu.chronicles.model.entries.PodcastEntry;
import edu.chronicles.model.exceptions.InvalidStateException;
import edu.chronicles.model.value_objects.UserRating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PodcastEntryTest {

    private static final String PODCAST_NAME = "DAndo que Hablar";

    private PodcastEntry podcastEntry;

    @BeforeEach
    void initializePodcast() { podcastEntry = new PodcastEntry(PODCAST_NAME); }

    @Test
    void shouldReturnErrorWhenRatingWithoutCompletion() {
        assertThrows(InvalidStateException.class, () -> podcastEntry.rate(UserRating.of(3)));
    }

}

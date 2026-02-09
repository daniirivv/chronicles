package entries;

import edu.chronicles.model.value_objects.Rating;
import edu.chronicles.model.entries.CourseEntry;
import edu.chronicles.model.exceptions.InvalidStateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CourseEntryTest {

    private static final String COURSE_NAME = "Web Scrapping";

    private CourseEntry courseEntry;

    @BeforeEach
    void initializeCourse() { courseEntry = new CourseEntry(COURSE_NAME); }

    @Test
    void shouldReturnErrorWhenRatingWithoutCompletion() {
        assertThrows(InvalidStateException.class, () -> courseEntry.rate(Rating.of(3)));
    }

}

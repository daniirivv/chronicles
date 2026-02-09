package repositories;

import edu.chronicles.model.entries.BookEntry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepositoryTest {

    private static final String BOOK_TITLE = "Atomic Habits";
    BookEntry exampleEntry = new BookEntry("BOOK_TITLE");

    @Test
    void givenAnyEntry_onSave_shouldSaveCorrectlyIntoRepository(){
        // Arrange
        Repository repo = new BookRepository();

        // Act
        repo.save(exampleEntry);

        // Assert
        assertTrue(repo.findById(exampleEntry).isPresent());
    }
}

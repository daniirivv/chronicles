package repositories;

import edu.chronicles.state.entries.BookEntry;
import edu.chronicles.state.repositories.BookEntryRepository;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepositoryTest {

    private static final String BOOK_TITLE = "Atomic Habits";
    BookEntry exampleEntry = new BookEntry(BOOK_TITLE);

    @Test
    void givenAnyEntry_onSave_shouldSaveCorrectlyIntoRepository(){
        // Arrange
        BookEntryRepository repo = new BookEntryRepository(new HashMap<>());

        // Act
        repo.save(exampleEntry);

        // Assert
        assertTrue(repo.getByTitle(exampleEntry.getBookTitle()).isPresent());
    }
}

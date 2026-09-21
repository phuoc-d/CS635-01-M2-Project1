package Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Main.Book;
import Main.Ebook;

public class BookTest {

    private Book bookReality;

    @BeforeEach
    void setUp() {
        bookReality = new Book("Reality Fracture", "Wizards of the Coast", true);
    }

    @Test
    void matches_titleMatch(){
        assertEquals(true, bookReality.matches("Reality Fracture"));
    }

    @Test
    void matches_authorMatch(){
        assertEquals(true, bookReality.matches("Wizards of the Coast"));
    }

    @Test
    void matches_NoMatch(){
        assertEquals(false, bookReality.matches("Secret of Strixhaven"));
    }

    @Test
    void ebookIsAvailable_alwaysTrue(){
        Ebook ebook = new Ebook("Star Trak", "Gene Roddenberry", true);
        ebook.setAvailable(false);

        assertTrue(ebook.isAvailable());
    }
}
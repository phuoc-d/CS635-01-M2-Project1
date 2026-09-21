package Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Main.Book;
import Main.Customer;

public class UserTest {

    private Customer Phuoc;
    private Book bookReality;

    @BeforeEach
    void setUp() {
        Phuoc = new Customer(1, "Phuoc");
        bookReality = new Book("Reality Fracture", "Wizards of the Coast", true);
    }

    @Test
    void addBorrowedBook_addsToList(){
        Phuoc.addBorrowedBook(bookReality);
        assertTrue(Phuoc.getBorrowedBooks().contains(bookReality));
    }

    @Test
    void returnBorrowedBook_bookWasBorrowed(){
        Phuoc.addBorrowedBook(bookReality);
        Phuoc.returnBorrowedBook(bookReality);
        assertFalse(Phuoc.getBorrowedBooks().contains(bookReality));
    }

    @Test
    void returnBorrowedBook_bookNeverBorrowed(){
        assertThrows(IllegalStateException.class, () -> Phuoc.returnBorrowedBook(bookReality));
    }

    @Test
    void matches_nameMatch(){
        assertTrue(Phuoc.matches("Phuoc"));
    }

    @Test
    void matches_noMatch(){
        assertFalse(Phuoc.matches("Nobody"));
    }
}
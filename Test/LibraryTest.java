package Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Main.Library;
import Main.Book;
import Main.Customer;
import Main.User;

public class LibraryTest {

    private Library library;
    private Book bookReality;
    private Customer Phuoc;

    @BeforeEach
    void setUp() {
        library = new Library();
        bookReality = new Book("Reality Fracture", "Wizards of the Coast", true);
        Phuoc = new Customer(1, "Phuoc");

        library.addBook(bookReality);  
        library.addUser(Phuoc);
        
    }

    @Test
    void checkOutBook_availableBook(){
        library.checkOutBook(Phuoc, bookReality);
        assertEquals(bookReality.isAvailable(), false);
        assertEquals(bookReality, Phuoc.getBorrowedBooks().get(0));
    } 
    
    @Test 
    void checkOutBook_nonavailableBook(){
        library.checkOutBook(Phuoc, bookReality);
        assertThrows(IllegalStateException.class, () -> library.checkOutBook(Phuoc, bookReality));
    }

    @Test 
    void checkOutBook_nullUser(){
        assertThrows(IllegalArgumentException.class, () -> library.checkOutBook(null, bookReality));
    }

    @Test 
    void checkOutBook_nullBook(){
        assertThrows(IllegalArgumentException.class, () -> library.checkOutBook(Phuoc, null));
    }

    @Test 
    void returnBook_availableBook(){
        library.checkOutBook(Phuoc, bookReality);
        assertEquals(bookReality, Phuoc.getBorrowedBooks().get(0));


        library.returnBook(Phuoc, bookReality);
        assertEquals(bookReality.isAvailable(), true);
        assertEquals(true, Phuoc.getBorrowedBooks().isEmpty());
    }
    
    @Test 
    void returnBook_neverBorrowed(){
        assertThrows(IllegalStateException.class, () -> library.returnBook(Phuoc, bookReality));
    }

    @Test 
    void returnBook_nullUser(){
        assertThrows(IllegalArgumentException.class, () -> library.returnBook(null, bookReality));
    }

    @Test 
    void returnBook_nullBook(){
        assertThrows(IllegalArgumentException.class, () -> library.returnBook(Phuoc, null));
    }

    @Test
    void addBook_validBook(){
        Book Strixheaven = new Book("Secret of Strixhaven", "Wizards of the Coast", true);
        library.addBook(Strixheaven);

        assertTrue(library.searchBook("Strixhaven").contains(Strixheaven));
    }

    @Test 
    void addBook_Null(){
        assertThrows(IllegalArgumentException.class, () -> library.addBook(null));
    }

    @Test
    void addUser_validUser(){
        Customer Jt = new Customer(2, "Jt");
        library.addUser(Jt);

        assertTrue(library.searchUser("Jt").contains(Jt));
    }

    @Test 
    void addUser_null(){
        assertThrows(IllegalArgumentException.class, () -> library.addUser(null));
    }

    @Test
    void searchBook_matchesTitle(){
        assertTrue(library.searchBook("Reality").contains(bookReality));
    }

    @Test
    void searchBook_matchesAuthor(){
        List<Book> search = library.searchBook("Wizards of the Coast");
        assertTrue( search.contains(bookReality));
    }

    @Test 
    void searchBook_noMatch(){
        List<Book> search = library.searchBook("Harry Potter");
        assertEquals( 0 , search.size());
    }

    @Test 
    void searchUser_matchesName(){
        List<User> search = library.searchUser("Phuoc");
        assertTrue( search.contains(Phuoc));
    }

    @Test 
    void searchUser_noMatch(){
        List<User> search = library.searchUser("Joe");
        assertEquals( 0 , search.size());
    }
}
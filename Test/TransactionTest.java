package Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Main.Book;
import Main.Customer;
import Main.Transaction;
import Main.BorrowTransaction;
import Main.ReturnTransaction;

public class TransactionTest {

    private Book bookReality;
    private Customer Phuoc;

    @BeforeEach
    void setUp() {
        bookReality = new Book("Reality Fracture", "Wizards of the Coast", true);
        Phuoc = new Customer(1, "Phuoc");
    }

    @Test
    void borrowTransaction_availableBook(){
        Transaction trans = new BorrowTransaction(Phuoc, bookReality);
        trans.execute();

        assertFalse(bookReality.isAvailable());
        assertTrue(Phuoc.getBorrowedBooks().contains(bookReality));
    }

    @Test
    void borrowTransaction_unavailableBook(){
        Transaction firstTrans = new BorrowTransaction(Phuoc, bookReality);
        firstTrans.execute();

        assertThrows(IllegalStateException.class, () -> new BorrowTransaction(Phuoc, bookReality).execute());
    }

    @Test
    void returnTransaction_borrowedBook(){
        Transaction borrow = new BorrowTransaction(Phuoc, bookReality);
        borrow.execute();

        Transaction returnTrans = new ReturnTransaction(Phuoc, bookReality);
        returnTrans.execute();

        assertTrue(bookReality.isAvailable());
        assertFalse(Phuoc.getBorrowedBooks().contains(bookReality));
    }

    @Test
    void polymorphism_sameReferenceTypeDifferentBehavior(){
        Transaction trans = new BorrowTransaction(Phuoc, bookReality);
        trans.execute();

        assertFalse(bookReality.isAvailable());

        trans = new ReturnTransaction(Phuoc, bookReality);
        trans.execute();

        assertTrue(bookReality.isAvailable());
    }
}
package Main;

import java.util.ArrayList;
import java.util.List;

public abstract class User implements Searchable {
    private final int id;
    private final String name;
    private List<Book> borrowedBooks;
    
    public User(int id, String name){
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Book> getBorrowedBooks(){
        return this.borrowedBooks;
    }

    public void addBorrowedBook(Book book){
        borrowedBooks.add(book);
    }

    public void returnBorrowedBook(Book book){
    
        if ( borrowedBooks.remove(book) == false ){
            throw new IllegalStateException("This user did not borrow this book.");
        }
    }

    @Override
    public boolean matches( String compareSearch) {
            return (this.name.toLowerCase()).contains(compareSearch.toLowerCase());

    }
}

package Main;

import java.util.*;

public class Library {
    private List<Book> allBook;
    private List<User> allUser;

    public Library(){
        this.allBook = new ArrayList<Book>();
        this.allUser = new ArrayList<User>();

    }

    public void checkOutBook(User user, Book book){
        if (user == null || book == null) { 
            throw new IllegalArgumentException("User or Book cannot be null."); 
        }
        Transaction trans = new BorrowTransaction(user,book);
        trans.execute();
    }

    public void returnBook( User user, Book book){
        if (user == null || book == null) { 
            throw new IllegalArgumentException("User or Book cannot be null."); 
        }
        Transaction trans = new ReturnTransaction(user, book);
        trans.execute();
    }

    public void addUser( User user){
        if (user == null) { 
            throw new IllegalArgumentException("User cannot be null."); 
        }
        allUser.add(user);
    }

    public void addBook( Book book ){
        if (book == null) { 
            throw new IllegalArgumentException("Book cannot be null."); 
        }
        allBook.add(book);
    }

    public ArrayList<Book> searchBook(String queryBook){
       if (queryBook == null) { 
            throw new IllegalArgumentException("Search cannot be null."); 
        }

        ArrayList<Book> matchingArray = new ArrayList<>();
        for ( int i = 0 ; i<allBook.size() ; i++ ){
            if (allBook.get(i).matches(queryBook)){
                matchingArray.add(allBook.get(i));
            }
        }
        return matchingArray;

    }

    public ArrayList<User> searchUser(String queryUser){
        if (queryUser == null) { 
            throw new IllegalArgumentException("Search cannot be null."); 
        }
        ArrayList<User> matchingArray = new ArrayList<>();
        for ( int i = 0 ; i<allUser.size() ; i++ ){
            if (allUser.get(i).matches(queryUser)){
                matchingArray.add(allUser.get(i));
            }
        }
        return matchingArray;

    }
}

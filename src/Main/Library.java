package Main;

import java.util.*;

//Central piece of the library management system holding the data for all books and users
//contains the core mechanics of the library such as checking out, returning, adding user/books, etc
public class Library {
    private List<Book> allBook;
    private List<User> allUser;

    public Library(){
        this.allBook = new ArrayList<Book>();
        this.allUser = new ArrayList<User>();

    }

    //Logic is handled inside the respective transaction class
    public void checkOutBook(User user, Book book){
        if (user == null || book == null) { 
            throw new IllegalArgumentException("User or Book cannot be null."); 
        }
        Transaction trans = new BorrowTransaction(user,book);
        trans.execute();
    }

    //Logic is handled inside the respective transaction class
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

    //Search through the allbooks list each index at a time comparing the key to the index value
    //matching books are added to a return List then later returned
    //This can either be used for author or book title
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

    //Search through the allUser list each index at a time comparing the key to the index value
    //matching user are added to a return List then later returned
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

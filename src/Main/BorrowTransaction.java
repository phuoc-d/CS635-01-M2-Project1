package Main;

// Represents the act of checking a book from the library to the user
public class BorrowTransaction extends Transaction{

    public BorrowTransaction(User user, Book book) {
        super(user, book);
    }

    //This marks the book as unavailable and added it to the users borrowed list
    //If the book is unavailble, throw an exception
    @Override
    public void execute() {
        if ( this.getBook().isAvailable() == true){
           this.getUser().addBorrowedBook(this.getBook());
           this.getBook().setAvailable(false);
        }
        else{
        throw new IllegalStateException("book is not available");
        }
    }
    
}

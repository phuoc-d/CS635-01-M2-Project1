package Main;

// Returns the borrowed book back to the library
public class ReturnTransaction extends Transaction {

    public ReturnTransaction(User user, Book book) {
        super(user, book);
    }

    //This makes the book available and removes it from the users borrowed list
    //throws and execption if the book wasn't actaully borrowed
    @Override
    public void execute() {
        this.getUser().returnBorrowedBook(this.getBook());
       this.getBook().setAvailable(true);
    }
    
}

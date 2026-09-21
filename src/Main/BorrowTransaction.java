package Main;

public class BorrowTransaction extends Transaction{

    public BorrowTransaction(User user, Book book) {
        super(user, book);
    }

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

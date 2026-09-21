package Main;

public class ReturnTransaction extends Transaction {

    public ReturnTransaction(User user, Book book) {
        super(user, book);
    }

    @Override
    public void execute() {
        this.getUser().returnBorrowedBook(this.getBook());
       this.getBook().setAvailable(true);
    }
    
}

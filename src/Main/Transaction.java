package Main;

//This class hols teh data of shared books and uasers needed by its sub class
public abstract class Transaction {
    private final Book book;
    private final User user;

    public Transaction(User user, Book book){
        this.book = book;
        this.user = user;
    }

    public Book getBook(){
        return this.book;
    }

    public User getUser(){
        return this.user;
    }

    //This is implemeted different in each subclass
    public abstract void execute();

}

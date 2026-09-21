package Main;

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

    public abstract void execute();

}

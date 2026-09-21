package Main;

// This is a subclass of book. Digital books are always available so isAvailable is overridden
public class Ebook extends Book {
    public Ebook(String title, String author, boolean isAvailable){
        super(title, author, isAvailable);
    }

    @Override 
    public boolean isAvailable(){
        return true;
    }
}

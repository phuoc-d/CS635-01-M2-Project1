package Main;

// This represents a single book inside the library
public class Book implements Searchable {
    private final String title;
    private final String author;
    private boolean available;

    public Book(String title, String author, boolean available){
        this.title = title;
        this.author = author;
        this.available = available;
    }

    public boolean isAvailable(){
        return available;
    }

    public void setAvailable(boolean boo){
        this.available = boo;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    //Allows books to be compared with other books inside the library.search(query) function
    @Override
    public boolean matches(String compareSearch) {
        String compareLowercased = compareSearch.toLowerCase();
        boolean boolTitle = (this.title.toLowerCase()).contains(compareLowercased);
        boolean boolAuthor = (this.author.toLowerCase()).contains(compareLowercased);

        return boolAuthor || boolTitle;
    }

}

package Main;

//implemented by both users and books, helper function for searchbook and search user
public interface Searchable {

    public boolean matches(String name);

}

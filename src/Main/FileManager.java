package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

//Handle all saving and loading data to txt files
public class FileManager {
    
    //This saves the list of books onto the first line of the text file.
    //Each book is converted to a string then added to one larger string contain all books
    //Works the same for usersm but users is placed on the second line
    public void saveAll(List<Book> books , List<User> users , String filename) throws IOException{
        String stringBook = "";
        for ( Book curr : books ){
            String title = (curr.getTitle());
            String author = curr.getAuthor();
            boolean isAvailable = curr.isAvailable();

            stringBook += title + "," + author + "," + isAvailable + ";";

        }

        String stringUser = "";
        for ( User currUser : users ){
            String id = Integer.toString(currUser.getId());
            String name = currUser.getName();

            stringUser += id + "," + name + ";";
             
        }


        File file = new File(filename);
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        pw.println(stringBook);
        pw.println(stringUser);

        pw.close();
    }

    //"src/Main/DataFile.txt")
    //Scans the first line of the text file which contains a large string of all books
    //Then this function splits up all the strings and parse them backing into book objects
    public List<Book> loadBooks( String filePath){
        List<Book> allBook = new ArrayList<>();

        try {
            File file = new File(filePath);
            Scanner scan = new Scanner(file);

            

            String currLine = scan.nextLine();
            scan.close();

            String[] stringBook = currLine.split(";");

            for ( String book : stringBook){
                String[] parameter = book.split(",");

                Book currBook = new Book(parameter[0], parameter[1], Boolean.parseBoolean(parameter[2]));
                allBook.add(currBook);
            }
        } catch ( FileNotFoundException e ){

        }
        return allBook;
    }


    //Data for users is placed on the second line of the text files
    //Scans the first line of the text file which contains a large string of all users
    //Then this function splits up all the strings and parse them backing into user objects
    public List<User> loadUsers( String filePath ){
        
        List<User> allUser = new ArrayList<>();
        
        try{
            File file = new File(filePath);
            Scanner scan = new Scanner(file);

            scan.nextLine();
            String currLine = scan.nextLine();
            scan.close();

            String[] stringUser = currLine.split(";");

            for ( String user : stringUser){
                String[] parameter = user.split(",");

                User currUser = new Customer(Integer.parseInt(parameter[0]), parameter[1]);
                allUser.add(currUser);
            }
        } catch ( FileNotFoundException e){

        }
        return allUser;
    }


}

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Contacts {
private String name;
private String phoneNumber;

    public static void main(String[] args) throws IOException {


        ///Created data directory and contacts.txt///

        String directory = "src/data";
        String contacts = "contacts.txt" ;

        Path dataDirectory = Paths.get(directory);
        Path contactFile = Paths.get(directory, contacts);

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (! Files.exists(contactFile)) {
            Files.createFile(contactFile);
        }

        ///Menu selections///

        String menu = "menu.txt" ;

        Path menuFile = Paths.get(directory, menu);

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (! Files.exists(menuFile)) {
            Files.createFile(menuFile);
        }

        ///This created the contacts array///

        List<String> contactList = Arrays.asList("Name | Phone number", "Mike Jones | 281-330-8004");
        Path filepath = Paths.get("src/data", "contacts.txt");
        Files.write(filepath, contactList);



        /// Menu array///
        List<String> menuList = Arrays.asList("View Contacts", "Add a new contact", "Search a contact by name and/or phone number", "Delete an existing contact", "Exit");
        Path menuPath = Paths.get("src/data", "menu.txt");
        Files.write(menuPath, menuList);

    }
}

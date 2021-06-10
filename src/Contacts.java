import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
            List<String> contactList = Arrays.asList("Name | Phone number", "Mike Jones | 281-330-8004");
            Path filepath = Paths.get("src/data", "contacts.txt");
            Files.write(filepath, contactList);
        }

        ///This created the contacts array///





        /// Menu array///
        List<String> menuList = Arrays.asList("View Contacts", "Add a new contact", "Search a contact by name and/or phone number", "Delete an existing contact", "Exit");
        Path menuPath = Paths.get("src/data", "menu.txt");
        Files.write(menuPath, menuList);


        //print menu to console
        Path menusPath = Paths.get("src/data", "menu.txt");
        menuList = Files.readAllLines(menusPath);

        for (int i = 0; i < menuList.size(); i += 1) {
            System.out.println((i + 1) + ": " + menuList.get(i));
        }


        //print select option and scanner
        System.out.println("Pick an option (1, 2, 3, 4, or 5): \n");

        Scanner scanner = new Scanner(System.in);

        int userInput = scanner.nextInt();

        System.out.println("You entered option: " + userInput);


        // give feedback to user input
        if (userInput == 1){
            Path contactsPath = Paths.get("src/data", "contacts.txt");
            List<String>contactList = Files.readAllLines(contactsPath);

            for (String s : contactList) {
                System.out.println(s);
            }



        } else if (userInput == 2){
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Enter new user contact name: ");
            String userInput2 = scanner2.nextLine();

            Scanner scanner3 = new Scanner(System.in);
            System.out.println("Enter new user phone number: ");
            String userInput3 = scanner3.nextLine();


            // adds userinput2 and 3 to contacts.txt
            Files.write(
                    Paths.get("src/data", "contacts.txt"),
                    Arrays.asList(userInput2 + " | " + userInput3), // list with one item
                    StandardOpenOption.APPEND
            );
        }



    }
}

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactReference {

    public void readFile(Path pathToFile) throws IOException {
        List<String> contactsList = Files.readAllLines(pathToFile);

        System.out.println("Name | Phone number \n---------------");
        for (String s : contactsList) {
            System.out.println(s);
        }
    }

    public void writeFile(String name, int number) throws IOException{
        Files.write(
                Paths.get("src/src", "contacts.txt"),
                Arrays.asList("\n" + name + " | " + number),
                StandardOpenOption.APPEND
        );
    }

    public void parseFile(Path pathToFile, String searchStr) throws IOException{
        Scanner scan = new Scanner(pathToFile);
        while(scan.hasNext()){
            String line = scan.nextLine().toLowerCase().toString();
            if(line.contains(searchStr)){
                System.out.println(line);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Path contactsPath = Paths.get("src/src","contacts.txt");
        ContactReference contact = new ContactReference();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Contacts App! Please read the following options.");
        System.out.println(" Type '1' to View your contacts \n Type '2' to add a new contact \n Type '3' to Search a contact by name \n Type '4' to delete an existing contact \n Type '5' to Exit");
        int option = scanner.nextInt();

        switch (option){
            case 1 :
                System.out.println("Your selection was '1' : Displaying all contacts ");
                contact.readFile(contactsPath);
                break;
            case 2 :
                System.out.println("Your selection was '2' : Adding a new contact ");
                Scanner addContact = new Scanner(System.in);
                System.out.println("Enter the name of the contact you would like to add.");
                String name = addContact.nextLine();
                System.out.println(name);
                System.out.println("Enter the number of the contact you would like to add.");
                int number = addContact.nextInt();
                System.out.println(number);
                contact.writeFile(name,number);
                break;
            case 3 :
                System.out.println("Your selection was '3' : Search for a contact");
                Scanner search = new Scanner (System.in);
                System.out.println("Enter the name of the contact you would like to search for.");
                String searchString = search.nextLine();
                contact.parseFile(contactsPath, searchString);
                break;
            case 4 :
                System.out.println("Your selection was '4' ");
            case 5 :
                System.out.println("Exiting Application");
                break;
            default:
                System.out.println(option);
        }



    }
}



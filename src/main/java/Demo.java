import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws ContactException, PhoneBookException, IOException {
//         Create directory
//         File dir = new File("phoneBookFiles");
//         dir.mkdir();

//        File testPhoneBook = new File("phoneBookFiles", "testPhoneBook.txt");
//        try {
//            testPhoneBook.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        File file = new File("phoneBookFiles" + File.separator + "testPhoneBook.txt");
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = PhoneBook.getInstance(file);
        String command = "";
        while (!command.equals("7")) {
            System.out.println("MENU: ");
            System.out.println(
                    "1 -> CREATE PHONE BOOK (you can create only one on your device)\n" +
                    "2 -> CREATE NEW CONTACT IN PHONE BOOK\n" +
                    "3 -> REMOVE CONTACT\n" +
                    "4 -> FIND CONTACT BY NAME\n" +
                    "5 -> OVERVIEW OF ALL NAMES IN THE PHONE BOOK\n" +
                    "6 -> PLAY DEMO\n" +
                    "7 -> EXIT THE MENU\n"
            );
            command = scanner.nextLine();
            switch (command) {
                case "1":
//                    File testPhoneBook = new File("phoneBookFiles",
//                            "testPhoneBook" + new Random().nextInt(100) + ".txt");
//                    try {
//                        testPhoneBook.createNewFile();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
                    phoneBook = PhoneBook.getInstance(file);
                    System.out.println("You already have a phone book!");
                    break;
                case "2":
                    System.out.println("Insert first name and last name: ");
                    String fullName = scanner.nextLine();
                    System.out.println("Insert phone number: \n'Example +359888123456'");
                    String phoneNumber = scanner.nextLine();
                    phoneBook.writeContact(fullName, phoneNumber);
                    phoneBook.saveChanges(file);
                    break;
                case "3":
                    System.out.println("Insert first name and last name: ");
                    String fullNameForRemove = scanner.nextLine();
                    phoneBook.removeContact(fullNameForRemove);
                    phoneBook.saveChanges(file);
                    break;
                case "4":
                    System.out.println("Insert first name and last name: ");
                    String fullNameForSearch = scanner.nextLine();
                    phoneBook.showMeThePhoneNumberOf(fullNameForSearch);
                    break;
                case "5":
                    phoneBook.printAllContacts();
                    break;
                case "6":
                    MadeACall calls = new MadeACall();
                    calls.madeACallSimulation(phoneBook);
                    break;
                case "7":
                    phoneBook.saveChanges(file);
                    System.out.println("Thank you for your attention!");
                    break;
                    default:
                        System.out.println("Invalid index of MENU!\n\n");
                        break;
            }
        }
    }
}

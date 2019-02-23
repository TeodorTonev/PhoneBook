import java.io.*;
import java.util.*;

public class PhoneBook {
    // Name of contact -> phone number
    private Map<String, String> contacts;
    // Contact -> count outgoing calls
    private Map<Contact, Integer> countCall;
    private List<Contact> contactsForRandom;
    private File file;
    private static PhoneBook instance = null;
    private static long outgoingCallsPhoneBook = 0;

    private PhoneBook(File file) throws FileNotFoundException, ContactException, PhoneBookException, UnsupportedEncodingException {
        if (file.exists() && file.isFile()) {
            this.file = file;
            Scanner scanner = new Scanner(this.file);
            this.contacts = new TreeMap<String, String>();
            this.countCall = new HashMap<Contact, Integer>();
            this.contactsForRandom = new ArrayList<Contact>();
            String normalPhoneNumber = "";

            while (scanner.hasNextLine()) {
                String[] token = scanner.nextLine().trim().split(" - ");
                if (token[1].startsWith("+359") && token[1].trim().length() == TypePhoneNumber.NORMAL.getPhoneNumberLength()) {
                    normalPhoneNumber = token[1];
                    Contact contact = new Contact(token[0], normalPhoneNumber);
                    this.contacts.put(token[0], normalPhoneNumber);
                    this.countCall.put(contact, 0);
                }
                if (token[1].startsWith("0") && token[1].trim().length() == TypePhoneNumber.WITH_ONE_ZERO.getPhoneNumberLength()) {
                    normalPhoneNumber = token[1].replaceFirst("0", "+359");
                    Contact contact = new Contact(token[0], normalPhoneNumber);
                    this.contacts.put(token[0], normalPhoneNumber);
                    this.countCall.put(contact, 0);
                }
                if (token[1].startsWith("00") && token[1].trim().length() == TypePhoneNumber.WITH_TWO_ZERO.getPhoneNumberLength()) {
                    normalPhoneNumber = token[1].replaceFirst("00", "+");
                    Contact contact = new Contact(token[0], normalPhoneNumber);
                    this.contacts.put(token[0], normalPhoneNumber);
                    this.countCall.put(contact, 0);
                }
                continue;
            }
            scanner.close();
        }
    }

    // Singleton class -> create only one phone book ->/for country, in mobile phone .../
    public static PhoneBook getInstance(File file) throws FileNotFoundException, ContactException, PhoneBookException, UnsupportedEncodingException {
        if (instance == null) {
            return new PhoneBook(file);
        }
        return instance;
    }

    public void writeContact(String contactFullName, String phoneNumber) throws PhoneBookException, ContactException, FileNotFoundException, UnsupportedEncodingException {
        if (contactFullName != null && phoneNumber != null && !(this.contacts.containsKey(contactFullName))) {
            Contact contact = new Contact(contactFullName, phoneNumber);

            this.contacts.put(contactFullName, phoneNumber);
            this.countCall.put(contact, 0);
            System.out.println("[Congratulations! The customer: " + contact.getFullName() + " with phone number " + contact.getPhoneNumber() + " is entered in the phone book!]");
            this.printAllContacts();
            System.out.println("------------------------------------------------------------------------------------");
        }
        else {
//            throw new PhoneBookException("The contact is invalid or is contained in the phone book!");
            System.out.println("The contact is invalid or is contained in the phone book!");
        }
    }

    public void removeContact(String contactFullName) throws PhoneBookException {
        if (contactFullName != null && this.contacts.containsKey(contactFullName) && !(this.contacts.isEmpty())) {
            this.contacts.remove(contactFullName);
            System.out.println("[The contact: " + contactFullName + " was deleted!]");
            System.out.println("In the phone book remained: ");
            this.printAllContacts();
        }
        else {
//            throw new PhoneBookException("The contact is invalid or is not contained in the phone book!");
            System.out.println("The contact is invalid or is not contained in the phone book!");
        }
    }

    public void showMeThePhoneNumberOf(String contactFullNmae) {
        if (contactFullNmae != null && contacts.containsKey(contactFullNmae)) {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                if (contactFullNmae.equals(entry.getKey()))
                    System.out.println("[Contact with name: " + contactFullNmae + " has a number: " + entry.getValue() + "]");
            }
        }
        else {
            System.out.println("Invalid contact name!");
        }
    }

    public void printAllContacts() {
        for (Map.Entry<String, String> entry : this.contacts.entrySet()) {
            System.out.println("[Contact with name " + entry.getKey() + " has a phone number " + entry.getValue() + "]");
        }
    }

    //the contact will surely take part in the call
    public Contact getCallerContact() {
        createNewCollection();
        PhoneBook.outgoingCallsPhoneBook++;
        return this.contactsForRandom.get(new Random().nextInt(this.contactsForRandom.size()));
    }

    public Contact getRecieverContact() {
        return this.contactsForRandom.get(new Random().nextInt(this.contactsForRandom.size()));
    }

    private void createNewCollection() {
        for (Contact contact : this.countCall.keySet()) {
            this.contactsForRandom.add(contact);
        }
    }

    public void increaseContactCallsByOne(Contact contact) {
        if (this.countCall.containsKey(contact)) {
            this.countCall.put(contact, this.countCall.get(contact) + 1);
        }
        else {
            this.countCall.put(contact, 1);
        }
    }

    public static long getOutgoingCallsPhoneBook() {
        return outgoingCallsPhoneBook;
    }

    public void bestContact() {
        Contact contact = null;
        int count = 0;
        for (Map.Entry<Contact, Integer> entry : this.countCall.entrySet()) {
            if (entry.getValue() > count) {
                count = entry.getValue();
                contact = entry.getKey();
            }
        }
        System.out.println("With the most calls: " + contact + " with " + count + " calls");
    }

    public void saveChanges(File file) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter(file, false)));
            for (Map.Entry<String, String> entry : this.contacts.entrySet()) {
                pw.println(entry.getKey() + " - " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            pw.close();
        }
    }
}

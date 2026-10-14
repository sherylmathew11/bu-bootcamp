import java.util.*;

public class ContactManager {
    public static void main(String[] args) {
        HashMap<String, Contact> contacts = new HashMap<>();

        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("Sheryl Mathew", new Contact("Sheryl Mathew", "+1 617 555 0102"));
        contacts.put("Sharon Mathew", new Contact("Sharon Mathew", "+1 617 555 0103"));
        contacts.put("James Adams", new Contact("James Adams", "+1 617 555 0104"));
        contacts.put("Abraham Lincoln", new Contact("Abraham Lincoln", "+1 617 555 0105"));

        System.out.println("=== Contact Lookup ===");

        Contact found = contacts.get("Ada Lovelace");
        if (found == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(found);
        }

        Contact missing = contacts.get("Apple Pineapple");
        if (missing == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(missing);
        }

        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        System.out.println();
        System.out.println("=== All Contacts ===");

        for (Contact contact : sorted) {
            System.out.println(contact);
        }
    }
}


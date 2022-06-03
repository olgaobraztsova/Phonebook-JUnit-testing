import java.util.*;

public class Phonebook {

    private final Map<String, List<Contact>> phoneBook = new HashMap<>();

    public void addGroup(String groupName) {
        if (!phoneBook.containsKey(groupName)) {
            phoneBook.put(groupName, new ArrayList<Contact>());
        }
    }

    public void addContactToGroup(Contact contact, String... groups) {

        for (String groupName : groups) {
            if (!phoneBook.containsKey(groupName)) {
                addGroup(groupName);
            }
            final List<Contact> contacts = phoneBook.get(groupName);
            contacts.add(contact);
        }

    }

    public List<Contact> findByGroup(String groupName) {
        return phoneBook.get(groupName);
    }

    public Contact findByPhone(String phoneNumber) {
        for (List<Contact> group : phoneBook.values()) {
            for (Contact contact : group) {
                if (contact.getPhoneNumber().equals(phoneNumber)) {
                    return contact;
                }
            }
        }
        return null;
    }



    public List<String> listAllGroups() {
        return new ArrayList<>(phoneBook.keySet());
    }

    public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }
}

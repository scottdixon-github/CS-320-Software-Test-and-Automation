import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private final Map<String, Contact> contacts;

    public ContactService() {
        contacts = new HashMap<>();
    }

    public boolean addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Invalid contact");
        }

        String contactID = contact.getContactID();
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID, must be less than 10 characters");
        }

        Contact existingContact = contacts.get(contactID);
        if (existingContact != null) {
            return false;
        }

        contacts.put(contactID, contact);
        return true;
    }

    public boolean removeContact(String contactID) {
        Contact removedContact = contacts.remove(contactID);
        return removedContact != null;
    }

    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }

    public ArrayList<Contact> getAllContacts() {
        return new ArrayList<>(contacts.values());
    }

    public boolean updateContact(Contact    updatedContact) {
        if (updatedContact == null) {
            throw new IllegalArgumentException("Invalid contact");
        }

        String contactID = updatedContact.getContactID();
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID, must be less than 10 characters");
        }

        Contact existingContact = contacts.get(contactID);
        if (existingContact == null) {
            return false;
        }

        contacts.put(contactID, updatedContact);
        return true;
    }

    public int getContactById(String contactID) {
        return contacts.containsKey(contactID) ? 1 : 0;
    }
}

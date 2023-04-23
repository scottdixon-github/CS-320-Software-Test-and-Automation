import org.junit.Test;
import static org.junit.Assert.*;
// The test class for the ContactService class
class ContactServiceTest {
    // Instance variables for ContactService and two Contact objects
    private ContactService contactService;
    private Contact contact1;
    private Contact contact2;

    // This method is executed before each test method
    @BeforeEach
    void testValidContact() {
        // Create a new ContactService object and two Contact objects
        contactService = new ContactService();
        contact1 = new Contact("123", "Alice");
        contact2 = new Contact("123", "Bob");
    }

    // This method is executed after each test method
    @AfterEach
    void tearDown() {
        // Remove all contacts from the contact service
        contactService.removeAllContacts();
    }

    // Test method to check if a contact can be added
    @Test
    void testAddContact() {
        // Attempt to add the two Contact objects
        boolean result = contactService.addContact(contact1);
        assertTrue(result);

        result = contactService.addContact(contact2);
        assertTrue(result);
    }

    // Test method to check if an IllegalArgumentException occurs
    @Test
    void testAddNullContact() {
        //  expect an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(null);
        });
    }


    //  checking if a duplicate Contact object cannot be added
    @Test
    void testAddDuplicateContact() {
        // Attempt to add the same Contact object twice and expect the second attempt to fail
        boolean result = contactService.addContact(contact1);
        assertTrue(result);

        result = contactService.addContact(contact1);
        assertFalse(result);
    }

    // check if a contact can be removed successfully
    @Test
    void testRemoveContact() {
        // Add two Contact objects attempt to remove the first one
        contactService.addContact(contact1);
        contactService.addContact(contact2);

        boolean result = contactService.removeContact(contact1.getContactID());
        assertTrue(result);

        // Attempt to remove the same Contact
        result = contactService.removeContact(contact1.getContactID());
        assertFalse(result);
    }

    // Test method to check if Contact can be retrieved by ID
    @Test
    void testGetContact() {
        // Add two Contact objects and attempt to retrieve the first one by ID
        contactService.addContact(contact1);
        contactService.addContact(contact2);

        Contact result = contactService.getContact(contact1.getContactID());
        assertEquals(contact1, result);

        // Attempt to retrieve a Contact object with an invalid ID
        result = contactService.getContact("3");
        assertNull(result);
    }


    @Test
    void testUpdateContactWithLongID() {
        Contact contact = new Contact("12345678901", "Charlie");
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact(contact);
        });
    }

    @Test
    void testGetContactById() {
        contactService.addContact(contact1);
        contactService.addContact(contact2);

        int result = contactService.getContactById(contact1.getContactID());
        assertEquals(1, result);

        result = contactService.getContactById("3");
        assertEquals(0, result);
    }
}

import org.junit.Test;
import static org.junit.Assert.*;

public class ContactTest {

	// Test case for a valid contact
	@Test
	public void testValidContact() {
		Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Baltimore St");
		assertEquals("123", contact.getContactID());
		assertEquals("John", contact.getFirstName());
		assertEquals("Doe", contact.getLastName());
		assertEquals("1234567890", contact.getPhone());
		assertEquals("123 Baltimore St", contact.getAddress());
	}

	// Test case for a contact with a null ID
	@Test(expected = NullPointerException.class)
	public void testNullContactID() {
		Contact contact = new Contact(null, "John", "Doe", "1234567890", "123 Baltimore St");
	}

	// Test case for a contact with an invalid ID
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidContactID() {
		Contact contact = new Contact("12345678901", "John", "Doe", "1234567890", "123 Baltimore St");
	}

	// Test case for a contact with a null first name
	@Test(expected = NullPointerException.class)
	public void testNullFirstName() {
		Contact contact = new Contact("123", null, "Doe", "1234567890", "123 Baltimore St");
	}

	// Test case for an invalid first name
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidFirstName() {
		Contact contact = new Contact("123", "JohnJohnJohn", "Doe", "1234567890", "123 Baltimore St");
	}

	// Test case for a contact with a null last name
	@Test(expected = NullPointerException.class)
	public void testNullLastName() {
		Contact contact = new Contact("123", "John", null, "1234567890", "123 Baltimore St");
	}

	// Test case for a contact with an invalid last name
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidLastName() {
		Contact contact = new Contact("123", "John", "DoeDoeDoeDoeDoe", "1234567890", "123 Baltimore St");
	}

	// Test case for a contact with a null phone number
	@Test(expected = NullPointerException.class)
	public void testNullPhone() {
		Contact contact = new Contact("123", "John", "Doe", null, "123 Main St");
	}

	// Test case for a contact with an invalid phone number
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidPhone() {
		Contact contact = new Contact("123", "John", "Doe", "123456789", "123 Baltimore St");
	}

	// Test case for a contact with a null address
	@Test(expected = NullPointerException.class)
	public void testNullAddress() {
		Contact contact = new Contact("123", "John", "Doe", "1234567890", null);
	}

	// Test case for a contact with an invalid address (too long)
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidAddress() {
		Contact contact = new Contact("123", "John", "Doe", "1234567890", "1234567890123456789012345678901");
	}
}

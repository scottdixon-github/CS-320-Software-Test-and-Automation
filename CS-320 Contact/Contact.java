// CS-320 Java unit testing
// * Scott Dixon--March 18, 2023

import java.util.Objects;

public class Contact {
    public Contact(String contactID, String John) {
    }

    // Main method to test the Contact class
    public static void main(String[] args) {
        System.out.println("This routine takes in contact id, first and last name, phone number and address and tests using junit test.");
    }

    // Private instance variables
    private String contactID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor to initialize the Contact object
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        // Set the values using the setters
        this.setContactID(contactID);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPhone(phone);
        this.setAddress(address);
    }

    // Getter and setter methods
    public String getContactID() {
        return this.contactID;
    }

    public void setContactID(String contactID) {
        // Throw an exception if the input value is null
        Objects.requireNonNull(contactID, "contactID must be entered.");
        // Throw an exception if the input value is greater than 10 characters
        if (contactID.length() > 10) {
            throw new IllegalArgumentException("Invalid ID, must be less than 10 characters.");
        }
        // Set the instance variable to the input value
        this.contactID = contactID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        // Throw an exception if the input value is null
        Objects.requireNonNull(firstName, "firstName must not be null.");
        // Throw an exception if the input value is incorrect
        if (firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid Name, must be less than 10 characters.");
        }
        // Set the instance variable to the input value
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        // Throw an exception when input is empty
        Objects.requireNonNull(lastName, "lastName must not be null.");
        // Throw an exception if the input value is longer than 10 characters
        if (lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid Last Name, must be less than 10 characters.");
        }
        // Set the variable to the input value if it passes
        this.lastName = lastName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        // Throw an exception if the input is empty
        Objects.requireNonNull(phone, "phone number must not be null.");
        // Throw an exception if the input value is not exactly 10 characters
        if (phone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number, phone number must be exactly 10 characters.");
        }
        // Set the instance variable to the input value if it passes validation
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        // Throw an exception if the input value is null
        Objects.requireNonNull(address, "There must be a correct address for the input.");
        // Throw an exception if the input value is longer than 30 characters
        if (address.length() > 30) {
            throw new IllegalArgumentException("Invalid address, the address must be less than 30 characters.");
        }
        // Set the instance variable to
        this.address = address;
    }

  /*
    public void updateFirstName(String firstName) {
        this.setFirstName(firstName);
    }
    public void updateLastName(String lastName) {
       this.setLastName(lastName);
   }
   public void updatePhone(String phone) {
     this.setPhone(phone);
    }
   public void updateAddress(String address) {
    this.setAddress(address);
   }
  */

}

/**

Contact.Java
CS 320: Module 3 Milestone
Student: Philip Shaw
Date: 12/3/23

Requirements:
- The contact object shall have a required unique contact ID string that cannot be longer than 10 characters. The
  contact ID shall not be null and shall not be updatable.
- The contact object shall have a required firstName String field that cannot be longer than 10 characters. The
  firstName field shall not be null.
- The contact object shall have a required lastName String field that cannot be longer than 10 characters. The lastName
  field shall not be null.
- The contact object shall have a required phone String field that must be exactly 10 digits. The phone field shall not
  be null.
- The contact object shall have a required address field that must be no longer than 30 characters. The address field
 shall not be null.

*/

public class Contact {
// Private variable declarations:
    private final String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

// ******** Constructor method ********

    public Contact(String argID, String argFirstName, String argLastName, String argPhone, String argAddress) {

        // Use the inputValidator method to validate the input string argument lengths:
        if(!inputValidator(argID, 10, false)) {
            throw new IllegalArgumentException("There was a problem with the 'ID' input.");
        }

        if(!inputValidator(argFirstName, 10, false )) {
            throw new IllegalArgumentException("There was a problem with the 'First Name' input.");
        }

        if(!inputValidator(argLastName, 10, false)) {
            throw new IllegalArgumentException("There was a problem with the 'Last Name' input.");
        }

        if(!inputValidator(argPhone, 10, true)) {
            throw new IllegalArgumentException("There was a problem with the 'Phone' input.");
        }

        if(!inputValidator(argAddress, 30, false)) {
            throw new IllegalArgumentException("There was a problem with the 'Address' input.");
        }

        // Define instance attributes if input is valid:
        this.id = argID;
        this.firstName = argFirstName;
        this.lastName = argLastName;
        this.phone = argPhone;
        this.address = argAddress;
    }

// Method for checking if string input is the correct length:
public boolean inputValidator(String stringToTest, int subjectLength, boolean fixedLength) {
    if (!fixedLength) {
        if (stringToTest != null &&
                (!stringToTest.isEmpty() && stringToTest.length() < (subjectLength + 1))) {
            return true;
        } else {
            return false;
        }
    }  else {
        if (stringToTest != null && stringToTest.length() == subjectLength) {
            return true;
        } else {
            return false;
        }
    }
}

// ******** Mutator/Setter methods ********

    public void changeFirstName(String argFirstName) {
        if(!inputValidator(argFirstName, 10, false)) {
            throw new IllegalArgumentException("There was a problem with the 'First Name' input format.");
        }
        this.firstName = argFirstName;
    }

    public void changeLastName(String lastName) {
        if(!inputValidator(lastName, 10, false)) {
            throw new IllegalArgumentException("There was a problem with the 'Last Name' input format.");
        }
        this.lastName = lastName;
    }

    public void changePhone(String phone) {
        if(!inputValidator(phone, 10, true)) {
            throw new IllegalArgumentException("There was a problem with the 'Phone' input format.");
        }
        this.phone = phone;
    }

    public void changeAddress(String address) {
        if(!inputValidator(address, 30, false)) {
            throw new IllegalArgumentException("There was a problem with the 'Phone' input format.");
        }
        this.address = address;
    }

// ******** Accessor/Getter methods ********

    public String returnID() {
        return id;
    }
    public String returnFirstName() {
        return firstName;
    }
    public String returnLastName() {
        return lastName;
    }
    public String returnPhone() {
        return phone;
    }
    public String returnAddress() {
        return address;
    }
}
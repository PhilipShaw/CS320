/**

 ContactTest.Java
 CS 320: Module 3 Milestone
 Student: Philip Shaw
 Date: 12/3/23

 Tests covered:
 - Contact objects can instantiate correctly
 - Objects with null ID fields can't be instantiated
 - Objects with IDs over 10 characters can't be instantiated
 - Objects with null first, last, phone or address fields can't be instantiated
 - Objects with first or last names over 10 characters can't be instantiated
 - Objects with phone numbers not equal to 10 characters can't be instantiated
 - objects with addresses over 30 characters can't be instantiated

 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void contactObjectInstantiatesCorrectly() {
        Contact testInstance = new Contact("1", "Bobby",
                "Boucher", "8005551234", "123 Main St.");
        assertEquals("1", testInstance.returnID());
        assertEquals("Bobby", testInstance.returnFirstName());
        assertEquals("Boucher", testInstance.returnLastName());
        assertEquals("8005551234", testInstance.returnPhone());
        assertEquals("123 Main St.", testInstance.returnAddress());
    }

    @Test
    public void idIsNull() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Bob",
                    "Barker", "8005551234", "123 Main St.");
        });
    }

    @Test
    public void idHas11Characters() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("11111111111", "Happy",
                    "Gilmore", "8005551234", "123 Main St.");
        });
    }

    @Test
    public void firstNameIsNull() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", null,
                    "Barker", "8005551234", "123 Main St.");
        });
    }

    @Test
    public void firstNameHas11Characters() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Bartholomew",
                    "Apostle", "8005551234", "123 Main St.");
        });
    }

    @Test
    public void lastNameIsNull() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Bob",
                    null, "8005551234", "123 Main St.");
        });
    }

    @Test
    public void lastNameHas11Characters() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Reese",
                    "Witherspoon", "8005551234", "123 Main St.");
        });
    }

    @Test
    public void phoneIsNull() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Bob",
                    "Hope", null, "123 Main St.");
        });
    }

    @Test
    public void phoneHas9Characters() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Ada",
                    "Lovelace", "800555123", "123 Main St.");
        });
    }

    @Test
    public void phoneHas11Characters() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Ada",
                    "Lovelace", "80055512345", "123 Main St.");
        });
    }

    @Test
    public void addressIsNull() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Billie",
                    "Eyelash", "8005551234", null);
        });
    }

    @Test
    public void addressHas31Characters() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "James",
                    "Kirk", "8005551234", "22 Oak St,Fayetteville,NC 28301");
        });
    }
}
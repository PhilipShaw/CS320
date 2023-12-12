/**

 ContactServiceTest.Java
 CS 320: Module 3 Milestone
 Student: Philip Shaw
 Date: 12/3/23

 Tests covered:
 - ContactService objects instantiate correctly
 - The ContactService class can remove objects
 - The ContactService class can update: first names, last names, phone numbers and addresses.
 -

 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    @Test
    public void contactServiceInstantiatesCorrectly() {
        ContactService rolodex = new ContactService();

        rolodex.createContact("Yosemite", "Sam",
                "866555ACME", "123 Smith & Wesson Way");

        Contact testContact = rolodex.getContactByID("1");  // ID indices begin at "1"
        assertEquals("1", testContact.returnID());

        assertEquals("1", testContact.returnID());
        assertEquals("Yosemite", testContact.returnFirstName());
        assertEquals("Sam", testContact.returnLastName());
        assertEquals("866555ACME", testContact.returnPhone());
        assertEquals("123 Smith & Wesson Way", testContact.returnAddress());
    }

    @Test
    public void contactServiceCanRemoveObjects() {
        ContactService rolodex = new ContactService();

        rolodex.createContact("Yosemite", "Sam",
                "866555ACME", "123 Smith & Wesson Way");

        assertEquals("1", rolodex.getContactByID("1").returnID());

        rolodex.removeContact("1");

        // Verify that the deleted contact's ID no longer exists in the rolodex container:
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            rolodex.getContactByID("1").returnID();
        });
    }

    @Test
    public void contactServiceCanUpdateFirstName() {
        ContactService rolodex = new ContactService();

        rolodex.createContact("Bugs", "Bunny",
                "866555ACME", "333 Hammer Lane");

        rolodex.updateFirstName("1", "Lola");
        Contact testContact = rolodex.getContactByID("1");

        assertEquals("Lola", testContact.returnFirstName());
    }

    @Test
    public void contactServiceCanUpdateLastName() {
        ContactService rolodex = new ContactService();

        rolodex.createContact("Bugs", "Bunny",
                "866555ACME", "333 Hammer Lane");

        rolodex.updateLastName("1", "Malone");
        Contact testContact = rolodex.getContactByID("1");
        assertEquals("Malone", testContact.returnLastName());
    }

    @Test
    public void contactServiceCanUpdatePhone() {
        ContactService rolodex = new ContactService();

        rolodex.createContact("Ronald", "Nixon",
                "8005559876", "1600 Penn Ave.");

        rolodex.updatePhone("1", "2125551234");
        Contact testContact = rolodex.getContactByID("1");

        assertEquals("2125551234", testContact.returnPhone());
    }

    @Test
    public void contactServiceCanUpdateAddress() {
        ContactService rolodex = new ContactService();

        rolodex.createContact("Sherlock", "Holmes",
                "0114477234", "221B Baker St.");

        rolodex.updateAddress("1", "10 Downing St.");
        Contact testContact = rolodex.getContactByID("1");

        assertEquals("10 Downing St.", testContact.returnAddress());
    }
}
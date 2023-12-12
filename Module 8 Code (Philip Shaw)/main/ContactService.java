/**

 ContactService.Java
 CS 320: Module 3 Milestone
 Student: Philip Shaw
 Date: 12/3/23

 Requirements:
 - The contact service shall be able to add contacts with a unique ID.
 - The contact service shall be able to delete contacts per contact ID.
 - The contact service shall be able to update contact fields per contact ID. The following fields are updatable:
 - firstName
 - lastName
 - number
 - address

 Note: getContactByID("String ID argument") method added to improve data encapsulation.

 */

import java.util.*;

public class ContactService {

    // Private list created to contain individual 'contact' objects:
    private List<Contact> contacts = new ArrayList<>();

    // Contact IDs are converted to longs to allow incrementation (before being re-converted to strings):
    long idLong = 1L;

    // Allow objects to be created from the Contact class:
    public void createContact(String argFirstName, String argLastName, String argPhone, String argAddress) {
        String idPlaceholder = Long.toString(idLong);
        Contact createContact = new Contact(idPlaceholder, argFirstName, argLastName, argPhone, argAddress);
        contacts.add(createContact);

        idLong = idLong + 1;
    }

    //  ******** Methods for updating and deleting existing Contact objects ********
    public void removeContact(String argID) {
        boolean contactRemoved = false;
        Iterator<Contact> contactsIterator = contacts.iterator();

        while (contactsIterator.hasNext()) {
            Contact user = contactsIterator.next();
            if(user.returnID().equals(argID)) {
                System.out.println("User: " + user.returnID() + " was removed from the contact list.");
                contactsIterator.remove();
                contactRemoved = true;
            }
        }
        if (!contactRemoved) {
            System.out.println("No contacts were removed.");
        }
    }

    public void updateFirstName(String argID, String argFirstName) {
        for(Contact user : contacts) {
            if(Objects.equals(user.returnID(), argID)) {
                user.changeFirstName(argFirstName);
            }
        }
    }

    public void updateLastName(String argID, String argLastName) {
        for(Contact user : contacts) {
            if(Objects.equals(user.returnID(), argID)) {
                user.changeLastName(argLastName);
            }
        }
    }
    public void updatePhone(String argID, String argPhone) {
        for(Contact user : contacts) {
            if(Objects.equals(user.returnID(), argID)) {
                user.changePhone(argPhone);
            }
        }
    }

    public void updateAddress(String argID, String argAddress) {
        for(Contact user : contacts) {
            if(Objects.equals(user.returnID(), argID)) {
                user.changeAddress(argAddress);
            }
        }
    }

    public Contact getContactByID(String argContactID) {
        Contact contactToReturn = null;

        for(Contact user : contacts) {
            if(Objects.equals(user.returnID(), argContactID)) {
                contactToReturn = user;
            }
        }

        if (contactToReturn == null) {
            throw new NoSuchElementException("The contact ID argument " + argContactID
                    + " is not in the list");
        } else {
            return contactToReturn;
        }
    }
}

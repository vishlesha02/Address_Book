package com.bridgelabz;

import java.util.*;
import java.util.stream.Collectors;

public class InputMethods {

    Scanner sc = new Scanner(System.in);

    ArrayList<Contacts> ContactList = new ArrayList<>();
    HashMap<String, ArrayList<Contacts>> addressBooks = new HashMap<>();

    public HashMap<String, ArrayList<Contacts>> getAddressBooks() {
        return addressBooks;
    }

    public void setAddressBooks(HashMap<String, ArrayList<Contacts>> addressBooks) {
        this.addressBooks = addressBooks;
    }


    @Override
    public String toString() {
        return "InputMethods{" +
                "sc=" + sc +
                ", ContactList=" + ContactList +
                ", addressBooks=" + addressBooks +
                '}';
    }

    public void createContact() {

        System.out.print("Enter First Name : ");
        String firstName = sc.next();

        boolean isDuplicate = ContactList.stream().anyMatch(person -> person.getFirstName().equals(firstName));
        if (isDuplicate) {
            System.out.println("Contact with " + firstName + " already exsist!!");
            return;
        }
        Contacts person = new Contacts();
        person.setFirstName(firstName);

        System.out.print("Enter Last Name : ");
        String lastName = sc.next();
        person.setLastName(lastName);

        System.out.print("Enter Address : ");
        String address = sc.next();
        person.setAddress(address);

        System.out.print("Enter City : ");
        String city = sc.next();
        person.setCity(city);

        System.out.print("Enter State : ");
        String state = sc.next();
        person.setState(state);


        System.out.print("Enter zip : ");
        String zip = sc.next();
        person.setZip(zip);

        System.out.print("Enter PhoneNumber : ");
        String phoneNumber = sc.next();
        person.setPhoneNumber(phoneNumber);

        System.out.print("Enter EmailId : ");
        String email = sc.next();
        person.setEmail(email);

        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        ContactList.add(person);
        // System.out.println(ContactList);


    }

    public void editContact() {
        System.out.println("Enter a name to edit : ");
        String newName = sc.next();
        boolean contactFound = false;

        for (int i = 0; i < ContactList.size(); i++) {
            Contacts contacts = ContactList.get(i);

            if (newName.equals(contacts.getFirstName())) {

                System.out.println("Enter option to edit :\n 1)First Name \n 2)Last Name \n 3)Address \n 4)City \n 5)State \n 6)Zip \n 7)Phone Number \n 8)Email ");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        ContactList.get(i).setFirstName(sc.next());
                        break;
                    case 2:
                        ContactList.get(i).setLastName(sc.next());
                        break;
                    case 3:
                        ContactList.get(i).setAddress(sc.next());
                        break;
                    case 4:
                        ContactList.get(i).setCity(sc.next());
                        break;
                    case 5:
                        ContactList.get(i).setState(sc.next());
                        break;
                    case 6:
                        ContactList.get(i).setZip(sc.next());
                        break;
                    case 7:
                        ContactList.get(i).setPhoneNumber(sc.next());
                        break;
                    case 8:
                        ContactList.get(i).setEmail(sc.next());
                        break;
                    default:
                        System.out.println("Invalid Option!!!");
                        break;

                }
                contactFound = true;
                System.out.println(ContactList);
            }
            if (!contactFound) {
                System.out.println("Contact not found with the given name: " + newName);
            }
        }
    }

    public void deleteContact() {
        System.out.println("Enter a name to delete");
        String newName = sc.next();
        boolean contactFound = false;

        for (int i = 0; i < ContactList.size(); i++) {
            Contacts contacts = ContactList.get(i);

            if (newName.equals(contacts.getFirstName())) {
                ContactList.remove(i);
                contactFound = true;
                System.out.println("Contact deleted.");
            }
        }
        if (!contactFound) {
            System.out.println("Contact not found with the given name: " + newName);
        }
    }

    public void addMultiplePerson() {
        System.out.println("Enter number of contacts you want to add");
        int input = sc.nextInt();

        for (int i = 0; i < input; i++) {
            createContact();
            System.out.println(i + 1 + " contact created successfully");
        }
        System.out.println(ContactList);
    }


    public void addMultipleAddressBook() {
        System.out.println("Enter number of address book you want to add");
        int noOfAddressBooks = sc.nextInt();

        for (int i = 1; i <= noOfAddressBooks; i++) {
            System.out.println("Enter the name for Address Book " + i);
            String addressBookName = sc.next();

            if (addressBooks.containsKey(addressBookName)) {
                System.out.println("Address Book with the name '" + addressBookName + "' already exists.");
            } else {
                InputMethods addressBook = new InputMethods();
                addressBook.setAddressBooks(addressBooks);
                addressBook.addMultiplePerson();
                ArrayList<Contacts> newContactList = new ArrayList<>(addressBook.getContactList());

                addressBooks.put(addressBookName, newContactList);
            }

        }
    }

    public void setContactList(ArrayList<Contacts> contactList) {
        this.ContactList = contactList;
    }

    private ArrayList<Contacts> getContactList() {
        return ContactList;
    }

    public void searchPersonInCityOrState() {
        System.out.println("Enter the name of the address book");
        String addressBookName = sc.next();

        if (!addressBooks.containsKey(addressBookName)) {
            System.out.println("Address book with name " + addressBookName + " not found.");
        } else {
            System.out.println("Enter the name of city or state");
            String cityOrState = sc.next();

            List<Contacts> filteredContacts = addressBooks.get(addressBookName).stream()
                    .filter(person -> person.getCity().equalsIgnoreCase(cityOrState) || person.getState().equalsIgnoreCase(cityOrState))
                    .collect(Collectors.toList());

            if (filteredContacts.isEmpty()) {
                System.out.println("No contacts found in " + cityOrState);
            } else {
                filteredContacts.forEach(System.out::println);
            }
        }
    }

    public void countPersonInCityOrState()
    {
        System.out.println("Enter the name of address book");
        String addressBookName = sc.next();

        if (!addressBooks.containsKey(addressBookName)) {
            System.out.println("Address book with name " + addressBookName + " not found.");
        } else {
            System.out.println("Enter name of city or state");
            String cityOrState = sc.next();

            List<Contacts> filteredContacts = addressBooks.get(addressBookName).stream()
                    .filter(person -> person.getCity().equalsIgnoreCase(cityOrState) || person.getState().equalsIgnoreCase(cityOrState))
                    .collect(Collectors.toList());
            long count = filteredContacts.size();


            if (filteredContacts.isEmpty()) {
                System.out.println("No contacts found in " + cityOrState);
            } else {
                System.out.println("Count: " + count);
            }

        }
    }

}




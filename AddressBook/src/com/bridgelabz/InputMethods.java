package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class InputMethods {

    Scanner sc=new Scanner(System.in);

    ArrayList<Contacts> ContactList=new ArrayList<>();
    public Contacts createContact()
    {
        System.out.print("Enter First Name : ");
        String firstName=sc.next();

        System.out.print("Enter Last Name : ");
        String lastName=sc.next();

        System.out.print("Enter Address : ");
        String address=sc.next();

        System.out.print("Enter City : ");
        String city= sc.next();

        System.out.print("Enter State : ");
        String state=sc.next();

        System.out.print("Enter zip : ");
        String zip=sc.next();

        System.out.print("Enter PhoneNumber : ");
        String phoneNumber=sc.next();

        System.out.print("Enter EmailId : ");
        String email=sc.next();

        System.out.println("---------------------------------------------------------------------------------------------------------------------------");

        Contacts person=new Contacts(firstName,lastName,address, city,state,zip,phoneNumber,email);
        ContactList.add(person);
        return person;
    }
    public void editContact()
    {
        System.out.println("Enter a Name to Edit : ");
        String newName=sc.next();
        boolean contactFound=false;

        for (int i=0;i<ContactList.size();i++) {
            Contacts contacts=ContactList.get(i);

            if(newName.equals(contacts.getFirstName()))
        {
            
            System.out.println("Enter option to edit :\n 1)First Name \n 2)Last Name \n 3)Address \n 4)City \n 5)State \n 6)Zip \n 7)Phone Number \n 8)Email ");
            int option=sc.nextInt();
            switch (option) {
                case 1: ContactList.get(i).setFirstName(sc.next());
                break;
                case 2: ContactList.get(i).setLastName(sc.next());
                break;
                case 3: ContactList.get(i).setAddress(sc.next());
                break;
                case 4: ContactList.get(i).setCity(sc.next());
                break;
                case 5: ContactList.get(i).setState(sc.next());
                break;
                case 6: ContactList.get(i).setZip(sc.next());
                break;
                case 7: ContactList.get(i).setPhoneNumber(sc.next());
                break;
                case 8: ContactList.get(i).setEmail(sc.next());
                break;
                default:
                    System.out.println("Invalid Option!!!");
                    break;

            }
            contactFound=true;
            System.out.println(ContactList);
        }
            if (!contactFound) {
                System.out.println("Contact not found with the given name: " + newName);
            }

        }


    }

}

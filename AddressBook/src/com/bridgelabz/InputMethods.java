package com.bridgelabz;

import java.util.Scanner;

public class InputMethods {

    Scanner sc=new Scanner(System.in);
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
        return person;

    }

}

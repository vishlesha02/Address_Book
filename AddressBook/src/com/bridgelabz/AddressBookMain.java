package com.bridgelabz;

import java.util.Scanner;

public class AddressBookMain {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("<<<======= ==== Welcome to Address Book! === =======>>>");
        InputMethods obj = new InputMethods();

        String s;
            do {
                System.out.println("Please Enter a Number for Following Options :\n 1) Add New Contact \n 2) Edit Contact \n 3) Delete Contact \n 4) Add Multiple Persons \n 5) Add Multiple AddressBooks");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        obj.createContact();
                        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                        break;

                    case 2:
                        obj.editContact();
                        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                        break;

                    case 3:
                        obj.deleteContact();
                        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                        break;
                    case 4:
                        obj.addMultiplePerson();
                        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                        break;
                    case 5:
                        obj.addMultipleAddressBook();
                        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                        break;
                    default:
                        break;

                }
                System.out.println("Do you want to have a look back? If Yes please press y");
                s=sc.next();
            }while(s.equals("y")||s.equals("Y"));
    }
}

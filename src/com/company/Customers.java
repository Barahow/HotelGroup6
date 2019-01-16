package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Customers {
    private final Scanner input;
    private final ArrayList<Customer> customers;

    public Customers() {
        input = new Scanner(System.in);
        customers = new ArrayList<>();
        // adding customers
        customers.add(new Customer("19551204-6253","James", "brown","25 street", "0723456245"));
        customers.add(new Customer("19851204-6253","Daniel","Castro","1 street", "075344424"));
        customers.add(new Customer("19901204-6253","Sam", "McClain","10 street", "07335668245"));

    }
    
    public void addCustomer() {
        Boolean a = true;
        String firstName = "", lastName = "", SSN = "", phoneNumber = "", address = "";

        boolean b = true;
        boolean c = true;
        boolean d = true;
        boolean e = true;
        String stringChoice;
        int id=0;


        System.out.print("Enter customer's ten digit social security number (YYMMDD-XXXX): ");
        SSN = input.nextLine();


        if (!String.valueOf(SSN.charAt(6)).equals("-") || id != 0 || SSN.length() != 11) {
            System.out.println("needs to be this format (YYMMDD-XXXX)");



        } else {

        }
        if (b) {
            System.out.print("Enter Customers Firstname: ");
            firstName = input.nextLine();

        } else {
            b = false;
        }
        if (c) {
            System.out.print("Enter Customers Lastname:: ");
            lastName = input.nextLine();

        } else {
            c = false;
        }
        if (d) {
            System.out.print("Enter Customers Address:: ");
            address = input.nextLine();
            System.out.print("Enter customer's Phonenumber: ");
            phoneNumber = input.nextLine();
        } else {
            d = false;
        }
        customers.add(new Customer(SSN, firstName, lastName, address, phoneNumber));

        System.out.println("Customer Added");
    }







    public void viewCustomer() {
        System.out.println("\nView Customer Details");
        System.out.print("Enter customer SSN :: ");
        String SSN = input.nextLine();

        // searching and getting the customer with the given SSN        
        Customer customer = findCustomer(SSN);

        // if customer was found with the given SSN
        if (customer != null) {
            System.out.println("\nCustomer SSN :: " + customer.getSSN());
            System.out.println("Customer first name :: " + customer.getFirstName());
            System.out.println("Customer last name :: " + customer.getLastName());
            System.out.println("Customer address :: " + customer.getAddress());
            System.out.println("Customer phone number :: " + customer.getPhoneNumber());
        }
        else
            System.out.println("\nCustomer not found!");
        waitForKeyEnter();
    }

    public void editCustomer() {
        System.out.println("\nEdit Customer Details");
        System.out.print("Enter customer SSN :: ");
        String SSN = input.nextLine();

        // searching and getting the customer with the given SSN        
        Customer customer = findCustomer(SSN);

        // if customer was found with the given SSN
        if (customer != null) {
            System.out.print("\nEnter customer new first name :: ");
            customer.setFirstName(input.nextLine());
            System.out.print("Enter customer new last name :: ");
            customer.setLastName(input.nextLine());
            System.out.print("Enter customer new address :: ");
            customer.setAddress(input.nextLine());
            System.out.print("Enter customer new phone number :: ");
            customer.setPhoneNumber(input.nextLine());
            System.out.println("\nCustomer Details Updated!");
        }
        else
            System.out.println("\nCustomer not found!");
        waitForKeyEnter();
    }

    public void deleteCustomer() {
        System.out.println("\nDelete Customer");
        System.out.print("Enter customer SSN :: ");
        String SSN = input.nextLine();

        // searching and getting the customer with the given SSN        
        Customer customer = findCustomer(SSN);

        // if customer was found with the given SSN
        if (customer != null) {
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getSSN().equals(SSN)) {
                    customers.remove(i);
                    break;
                }
            }
            System.out.println("\nCustomer Deleted!");
        }
        else
            System.out.println("\nCustomer not found!");
        waitForKeyEnter();
    }

    public void viewAllCustomers() {
        System.out.println("\nAll Customer Details");

        // printing details of each customer
        for (Customer customer : customers) {
            System.out.println("\nCustomer SSN :: " + customer.getSSN());
            System.out.println("Customer first name :: " + customer.getFirstName());
            System.out.println("Customer last name :: " + customer.getLastName());
            System.out.println("Customer address :: " + customer.getAddress());
            System.out.println("Customer phone number :: " + customer.getPhoneNumber());
            System.out.println();
        }
        waitForKeyEnter();
    }
    
    public Customer findCustomer(String SSN) {
        for (Customer customer : customers) {
            if(customer.getSSN().equals(SSN))
                return customer;
        }
        return null;
    }
    
    private void waitForKeyEnter() {
        System.out.print("Press enter key to continue...");
        input.nextLine();
    }

}
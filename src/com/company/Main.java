package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<Admin> listOfAdmins = new ArrayList<>();
    private ArrayList<Room> rooms = new ArrayList<>();
    private Room room;

    private Rooms listOfRooms = new Rooms();

    private enum Access {ADMIN, GUEST}

    private enum Filter {
        ALL, AVAILABLE, BOOKED, NAME, SSN, PHONE,
    }


    private Scanner userin = new Scanner( System.in );

    public static void main(String[] args) {

        Main hotelManagement = new Main();
        hotelManagement.listOfAdmins.add( new Admin( "admin", "0000", true ) );

        Access admin;
        boolean cont;
        boolean stayLoggedIn = true;
        int choice;


        while (stayLoggedIn) {
            admin = hotelManagement.login();
            cont = true;

            while (cont) {
                hotelManagement.startingMenu( admin );
                System.out.println( "Pleae input your choice" );
                choice = hotelManagement.userin.nextInt();


                switch (choice) {
                    case 1:
                        hotelManagement.printMenu1( admin );
                        break;
                    case 2:
                        hotelManagement.printMenu2( admin );
                    case 3:
                        hotelManagement.printMenu3( admin );
                        break;
                    case 4:
                        hotelManagement.addCustomer();
                        break;
                    case 5:
                        //hotelManagement.printMenu5( admin );
                        break;
                    case 6:
                        hotelManagement.userin.nextLine();
                        System.out.println( "" );
                        cont = false;
                        break;
                    case 7:
                        System.out.println( "exiting now...." );
                        cont = false;
                        stayLoggedIn = false;
                        break;


                }
            }


        }
    }

    private Access login() {
        Access Admin = null;
        for (int tries = 0; tries < 1; tries++) {
            System.out.println( "Enter your admin username" );
            String username = userin.nextLine();
            System.out.println( "Enter your admin password" );
            String password = userin.nextLine();
            for (int x = 0; x < listOfAdmins.size(); x++) {
                if (listOfAdmins.get( x ).getadminUser().equals( username ) && listOfAdmins.get( x ).getPassWord().equals( password ) && listOfAdmins.get( x ).getFullAccess()) {
                    System.out.println( "\nLogged in as " + username + "\n" );
                    x = listOfAdmins.size();
                    tries = 1;
                    Admin = Access.ADMIN;
                } else if (listOfAdmins.get( x ).getadminUser().equals( username ) && listOfAdmins.get( x ).getPassWord().equals( password ) && !listOfAdmins.get( x ).getFullAccess()) {
                    System.out.println( "\nLogged in as " + username + "\n" );
                    x = listOfAdmins.size();
                    tries = 1;
                    Admin = Access.GUEST;
                }
                if (tries == 2) {
                    System.exit( 0 );
                }
                if (tries != 3) {
                    System.out.println( "incorrect user or pw\n" );

                }


            }

        }
        return Admin;

    }

    private void startingMenu(Access type) {
        if (type == Access.ADMIN) {
            System.out.println( type + "" );
            System.out.println( "-----------------------------" );
            System.out.println( "| 1. New Booking" );
            System.out.println( "| 2. Manage Bookings" );
            System.out.println( "| 3. Manage Rooms " );
            System.out.println( "| 4. Manage Customers" );
            System.out.println( "| 5. Check Out Customer" );
            System.out.println( "| 6. Log Out " );
            System.out.println( "| 7. Exit" );
        } else {
            System.out.println( type );
            System.out.println( "1. make a new booking" );
            System.out.println( "2. view rooms" );
            System.out.println( "3. view booking history" );
            System.out.println( "4. Edit information" );
            System.out.println( "5. Edit booking" );
            System.out.println( "6. logout" );
            System.out.println( "7. exit" );
        }

    }

    private void printMenu1(Access type) {
        if (type == Access.ADMIN) {
            // create a new booking

        } else {
            // make a new booking)
        }
    }

    private void printMenu2(Access type) {
        int choice;

        if (type == Access.ADMIN) {
            //this is the manage booking method)
            System.out.println( "\n" + type );
            System.out.println( "1. edit a booking" );
            System.out.println( "2. Search for a booking" );
            System.out.println( "3. Back to main" );
        } else { //view all the rooms
            System.out.println( "\n" + type );
            System.out.println( "1. View all available rooms" );
            System.out.println( "2. View all rooms with dates" );
            System.out.println( "back to main" );
            System.out.print( "Enter your choice >>" );
            choice = userin.nextInt();
            System.out.println( "" );

            switch (choice) {
                case 1:
                    viewRooms( Filter.AVAILABLE );
                    break;


            }
        }

    }//manage the rooms method

    private void printMenu3(Access type) {
        int choice;

        if (type == Access.ADMIN) {
            System.out.println( "\n" + type );
            System.out.println( "1. View all AVAILABLE rooms" );
            System.out.println( "2. view rooms" );
            System.out.println( "3. Add a room" );
            System.out.println( "4. Remove a room" );
            System.out.println( "5. Back to the main menu" );
            System.out.println( "Enter your choice = = ?" );
            choice = userin.nextInt();

            switch (choice) {
                case 1:
                    viewRooms( Filter.AVAILABLE );

                case 2:
                    viewRooms( Filter.ALL );
                case 3:
                    removeRoom();
                    break;
                case 4:
                    bookRoom( 1 );
            }


        }

    }

    private void removeRoom() {
        for (int i = 0; i < rooms.size(); i++) {
            int roomNumber = 0;
            if (rooms.get( i ).getRoomNumber() == roomNumber) {
                rooms.remove( i );


            }
        }
    }

    private void bookRoom(int roomNumber) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get( i ).getRoomNumber() == roomNumber) {
                rooms.get( i ).setBooked( true );
            }
        }
    }


    private void viewRooms(Filter type) {
        if (type == Filter.ALL) {
            System.out.println( Filter.ALL );
            System.out.printf( "%s %5s %7s %11s%n", "RNR", "BEDS", "BALCONY", "PRICE (SEK)" );
            System.out.println( "-------" );
            for (int y = 0; y < listOfRooms.size(); y++) {
                System.out.printf( "%2d %5d %6s %10.2f    |%n", listOfRooms.get( y ).getRoomNumber(), listOfRooms.get( y ).getNumberOfBeds(), listOfRooms.get( y ).isHasBalcony() ? "Yes" : "No", listOfRooms.get( y ).getPricePerNight() );
            }
            System.out.println( "-------------------" );
            System.out.print( "Press H to return to main" );
            userin.nextLine();
            userin.nextLine();
            System.out.println( "" );
        } else if (type == Filter.AVAILABLE) {
            int cc = 0;
            System.out.println( Filter.ALL );
            System.out.printf( "%4s %4s %7s %5s", "Room", "BEDS", "Balcony", "price" );
            //System.out.printf( "%4s %4s %7s %5s", "Room", "BEDS", "Balcony", "price" );
            for (int x = 0; x < listOfRooms.size(); x++) {
                if (!listOfRooms.get( x ).isBooked()) ;
                System.out.printf( "%s %d %s %10.2f           I", listOfRooms.get( x ).getRoomNumber(), listOfRooms.get( x ).getNumberOfBeds(), listOfRooms.get( x ).isHasBalcony() ? "yes" : "no", listOfRooms.get( x ).getPricePerNight() );
                cc++;
                if ((x + 1) % 2 == 0) {
                    System.out.println( "" );
                }
                if (cc % 2 != 0) {
                    System.out.println( "" );
                }
                System.out.println( "-----------" );
                System.out.println( "press h to return to main" );
                userin.nextLine();
                userin.nextLine();
                System.out.println( "" );
            }


        }


    }

    private void printMenu4(Access type) { //method to manage the customer
        int choice;

        if (type == Access.ADMIN) {
            System.out.println( "\n" + type + "" );
            System.out.println( "1. Add a customer" );
            System.out.println( "2.remove a customer" );
            System.out.println( "3. view all customers" );
            System.out.println( "4. Back" );
            System.out.println( "enter your choice" );
            choice = userin.nextInt();
            System.out.println( "" );

            switch (choice) {
                case 1:
                    //   Customer(); // the method to add a customer
                    break;
                case 2:
                    removeCustomer();// the method to remove a customer
                    break;
                case 3:
                    viewAllCustomers(); //the method to view all customers
                    break;
                case 4:
                    // Back To Main Menu
                    break;

                default:
                    // ?
                    System.out.println( "Default statement: ADMIN\n" );
                    break;
            }

        } else {
            System.out.println( "\n" + type + "" );
            System.out.println( "----------------------" );
            System.out.println( "1. update address" );
            System.out.println( "2. Phone number" );
            System.out.println( "3. view info" );
            System.out.println( "4. to main " );
            System.out.println( "enter your choice" );
            choice = userin.nextInt();
            System.out.println( "" );

            switch (choice) {
                case 1: //update adress
                    break;
                case 2: // add phone number
                    break;
                case 3: //view info
                    break;
                case 4: // back to main
                default:
                    System.out.println( "Default statement: GUEST\n" );
                    break;

            }
        }


    }

    private void viewAllCustomers() {
        System.out.println( "----- Customers------" );
        System.out.println( "First Name: \t SSN: \t, phone Number: \t" );
        for (int i = 0; i < this.room.count(); i++) {
            Customer c = this.room.getCustomer( i );
            System.out.println( c.getId() );
            System.out.println( c.getName() );
            System.out.println( c.getSsn() );
        }
        {


        }


    }

    private void removeCustomer() {
    }
/*
    public void addCustomer() {
        System.out.println( "enter id" );
        int id = readInt( 0, Integer.MAX_VALUE );

        System.out.println("enter customer name");
        String name = userin.nextLine();
        System.out.println("enter your phone number");
        String phoneNum  = userin.nextLine();
        System.out.println("enter your ssn");
        String ssn = userin.nextLine();

        Customer c = new Customer(id, name, ssn );
        this.room.addCustomer( c );



    }
        private int readInt(int min, int max) {
            int choice;
            while (true) {
                try {
                    choice = Integer.parseInt(userin.nextInt());

                    if (choice >= min && choice <= max) {
                        break;
                    }

                } catch (Exception e) {
                    e.printStackTrace();

                }


            }
            return choice; */

    private void addCustomer() {

        String firstName, lastName, ssn, phoneNum;
        int cc = 0;
        userin.nextLine();

        cc = 0;
        System.out.print( "Enter customer's first name: " );
        firstName = userin.nextLine();
        // cc = validateString(firstName, Filter.NAME);
        cc = 0;
        System.out.print( "Enter customer's last name: " );
        firstName = userin.nextLine();
        //  cc = validateString(lastName, Filter.NAME);

        cc = 0;
        System.out.print( "Enter customer's ten digit social security number (YYMMDD-XXXX): " );
        ssn = userin.nextLine();
        // cc = validateString(ssn, Filter.SSN);
        cc = 0;
        System.out.print( "Enter customer's phone number: " );
        phoneNum = userin.nextLine();
        //cc = validateString(phoneNum, Filter.PHONE);


        //  public void printMenu5(Access type) {
        //print menu5 and its functions
    }


}
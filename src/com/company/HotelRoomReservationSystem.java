package com.company;

import java.util.Date;
import java.util.Scanner;

public class HotelRoomReservationSystem {
    private final Scanner input;
    private char choice;

    private final Customers customers;
    private final Rooms rooms;
    private final Bookings bookings;

    /**
     * Constructor.
     */
    public HotelRoomReservationSystem() {
        input = new Scanner(System.in);
        customers = new Customers();
        rooms = new Rooms();
        bookings = new Bookings();


    }

    /**
     * This method displays the main hotel management system.
     */
    public void showMainMenu() {
        while (true) {
            System.out.println("\n\nHotel Room Reservation System");
            System.out.println("1. Manage Customers");
            System.out.println("2. Manage Bookings");
            System.out.println("3. Manage Rooms");
            System.out.println("4. Exit");
            System.out.print("Enter choice :: ");
            choice = input.nextLine().charAt(0);

            // if user chooses to manage customers
            if (choice == '1')
                manageCustomers();

                // if user chooses to manage bookings
            else if (choice == '2')
                manageBookings();

                // if user chooses to manage rooms
            else if (choice == '3')
                manageRooms();

                // if user chooses to exit
            else if (choice == '4')
                break;

                // if user enters a wrong choice
            else
                invalidChoice();
        }
    }

    /**
     * This method displays that selected choice is wrong and waits for enter key.
     */
    private void invalidChoice() {
        System.out.println("\nInvalid Choice!");
        System.out.print("Press enter key to continue...");
        input.nextLine();
    }

    /**
     * This method displays the customer management options.
     */
    private void manageCustomers() {

        boolean running = true;
        while (running) {
            System.out.println("\n\nManage Customers");
            System.out.println("1. Add New Customer");
            System.out.println("2. View Customer Details");
            System.out.println("3. Edit Customer Details");
            System.out.println("4. Delete Customer");
            System.out.println("5. View All Customers");
            System.out.println("6. ****Search customer by name");
            System.out.println("7. Back to Main Menu");
            System.out.print("Enter choice :: ");
            choice = input.nextLine().charAt(0);


            switch (choice) {

                // if user chooses to add new customer
                case '1':
                    Customer customer = customers.addCustomer();
                    changeMe(customer);
                    break;

                // if user chooses to view customer details
                case '2':
                    customers.viewCustomer();
                    break;

                // if user chooses to edit customer details
                case '3':
                    customers.editCustomer();
                    break;

                // if user chooses to delete a customer
                case '4':
                    customers.deleteCustomer();
                    break;

                // if user chooses to view all customers details
                case '5':
                    customers.viewAllCustomers();
                    break;
                //****search customer by name
                case '6':
                   changeMe2();
                    break;

                // if user wants to go back to main menu
                case '7':
                    running = false;
                    break;

                // if user enters a wrong choice
                default:
                    invalidChoice();
                    break;

            }
        }
    }
    //=CHANGE ME
    private void changeMe(Customer customer) {
        //display all available rooms
        //make sure room number is unique or you get first occurence
        System.out.println("Please select an available room: ");
        for (int i = 0; i < rooms.getAvailbleRooms().size(); i++)
            System.out.printf("Room %d is free\n", rooms.getAvailbleRooms().get(i).getNumber());


        //should check user input valid room number
        System.out.print("Preferred room #; ");
        int roomNumber = input.nextInt();

        //get room obj out room number
        Room selectedRoom = null;
        Boolean found = false;
        for (int i = 0; i < rooms.getAvailbleRooms().size() && !found; i++){
            if (rooms.getAvailbleRooms().get(i).getNumber() == roomNumber) {
                selectedRoom = rooms.getAvailbleRooms().get(i);
                found = true;
            }
        }


        //if found is false here not match -> do something. Better check before






        //edit booking details here
        //I'll just make one, you'll need to do it for the following:
        // private int bookingNumber; - done
        //    private Customer customer; - done
        //    private Room room; - done
        //    private double stayPrice;
        //    private Date checkInDate;
        //    private Date checkOutDate;
        System.out.print("Booking number #; ");
        int bookingNumber = input.nextInt();

        //add booking - change with the missing args
        bookings.addBooking(new Booking(bookingNumber, customer, selectedRoom, new Date(), new Date()));

        System.out.printf("Booking %d added for the room %d\n", bookingNumber, selectedRoom.getNumber());


        //consume new line
        input.nextLine();


    }

    //=CHANGE ME 2
    private void changeMe2(){
        System.out.print("First name of the customer to search?: ");
        String firstName = input.next();

        //pick where to search the customers - within the bookings or within the customers?
        //i'll search into the bookings as it's a little bit more tedious
        Boolean found = false;

        //this one searches inside the booking but you need add a booking first - "Add new customer"
        for (int i=0;i<bookings.getBookings().size() && !found;i++){
            if (bookings.getBookings().get(i).getCustomer().getFirstName().equals(firstName)){

                System.out.println("User found:");
                //display all is data
                System.out.printf("Fist name: %s\nLast name: %s\nSSN: %s\nAddress: %s\nPhone number: %s\n", bookings.getBookings().get(i).getCustomer().getFirstName(), bookings.getBookings().get(i).getCustomer().getLastName(),bookings.getBookings().get(i).getCustomer().getSSN(), bookings.getBookings().get(i).getCustomer().getAddress(), bookings.getBookings().get(i).getCustomer().getPhoneNumber());

                found=true;
            }
        }




            //not found
         if (!found)
             System.out.println("No match");

        //consume new line
        input.nextLine();


    }

    /**
     * This method displays the booking management options.
     */
    private void manageBookings() {
        while (true) {
            System.out.println("\n\nManage Bookings");
            System.out.println("1. Search for booking");
            System.out.println("2. Check In Room");
            System.out.println("3. Check Out Room");
            System.out.println("4. Edit booking");
            System.out.println("5. View All Bookings");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter choice :: ");
            choice = input.nextLine().charAt(0);

            // if user chooses to search a booking details
            if (choice == '1')
                bookings.searchBooking();

                // if user chooses to check in a customer to room
            else if (choice == '2')
                bookings.checkInRoom(customers, rooms);

                // if user chooses to check out a customer to roon
            else if (choice == '3')
                bookings.checkOutRoom(customers, rooms);

                // if user chooses to edit a booking details
            else if (choice == '4')
                bookings.editBooking(customers, rooms);

                // if user chooses to view all booking details
            else if (choice == '5')
                bookings.viewAllBookings();

                // if user wants to go back to main menu
            else if (choice == '6')
                break;

                // if user enters a wrong choice
            else
                invalidChoice();
        }
    }

    /**
     * This method displays the room management options.
     */
    private void manageRooms() {
        while (true) {
            System.out.println("\n\nManage Rooms");
            System.out.println("1. Add New Room");
            System.out.println("2. View Room Details");
            System.out.println("3. Edit Room Details");
            System.out.println("4. Delete Room");
            System.out.println("5. View All Rooms");
            System.out.println("6. View All Available Rooms");
            System.out.println("7. Back to Main Menu");
            System.out.print("Enter choice :: ");
            choice = input.nextLine().charAt(0);

            // if user chooses to add new room
            if (choice == '1')
                rooms.addRoom();

                // if user chooses to view a room details
            else if (choice == '2')
                rooms.viewRoom();

                // if user chooses to edit a room details
            else if (choice == '3')
                rooms.editRoom();

                // if user chooses to delete a room details
            else if (choice == '4')
                rooms.deleteRoom();

                // if user chooses to view all rooms details
            else if (choice == '5')
                rooms.viewAllRooms();

                // if user chooses to view details of only available rooms
            else if (choice == '6')
                rooms.viewAllAvailableRooms();

                // if user wants to go back to main menu
            else if (choice == '7')
                break;

                // if user enters a wrong choice
            else
                invalidChoice();
        }
    }
}
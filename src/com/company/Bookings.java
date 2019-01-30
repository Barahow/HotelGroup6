package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Bookings {
    private final Scanner input;
    //you can't mark it final or you won't be able to add a booking later on
    private  ArrayList<Booking> bookings;

    public Bookings() {
        input = new Scanner(System.in);
        bookings = new ArrayList<>();
    }

    //add a booking
    public void addBooking(Booking booking){
        this.bookings.add(booking);
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void searchBooking() {
        System.out.println("\nSearch booking");
        System.out.print("Enter booking number :: ");
        int bookingNumber = Integer.parseInt(input.nextLine());

        // searching and getting the booking with the given booking number        
        Booking booking = findBooking(bookingNumber);

        // if booking was found with the given booking number
        if (booking != null) {
            System.out.println("\nBooking number :: " + booking.getBookingNumber());
            System.out.println("Customer name :: " + booking.getCustomer().getFirstName() + " " + booking.getCustomer().getLastName());
            System.out.println("Room number :: " + booking.getRoom().getNumber());
            System.out.println("Stay price :: " + booking.getStayPrice());
            System.out.println("Check-in date :: " + booking.getCheckInDate());
            System.out.println("Check-out date :: " + booking.getCheckOutDate());
        }
        else
            System.out.println("\nBooking not found!");
        waitForKeyEnter();
    }

    public void checkInRoom(Customers customers, Rooms rooms) {
        System.out.println("\nCheck In Booking");
        System.out.print("Enter booking number :: ");
        int bookingNumber = Integer.parseInt(input.nextLine());

        // searching and getting the booking with the given booking number        
        Booking booking = findBooking(bookingNumber);

        // if booking is not found with the given booking number
        if (booking == null) {

            // getting and setting new customer
            Customer customer;
            do {
                System.out.print("Enter customer SSN :: ");
                String SSN = input.nextLine();
                customer = customers.findCustomer(SSN);
            } while (customer == null);

            // getting and setting new room
            Room room;
            do {
                System.out.print("Enter room number :: ");
                int number = Integer.parseInt(input.nextLine());
                room = rooms.findRoom(number);
            } while (room == null || room.isBookedStatus());
            room.setBookedStatus(true);

            Date checkInDate = null;
            do {
                System.out.print("Enter new check-in date (DD-MM-YYYY) :: ");
                try {
                    checkInDate = (new SimpleDateFormat("dd-mm-yyyy")).parse(input.nextLine());
                } catch (ParseException ex) {}
            } while (checkInDate == null);

            Date checkOutDate = null;
            do {
                System.out.print("Enter new check-out date (DD-MM-YYYY) :: ");
                try {
                    checkOutDate = (new SimpleDateFormat("dd-mm-yyyy")).parse(input.nextLine());
                } catch (ParseException ex) {}
            } while (checkInDate == null);

            // adding new booking
            bookings.add(new Booking(bookingNumber, customer, room, checkInDate, checkOutDate));
            System.out.println("\nCustomer Check-in Successful!");
        }
        else
            System.out.println("\nBooking with this number already found!");
        waitForKeyEnter();
    }
    
    public void checkOutRoom(Customers customers, Rooms rooms) {
        System.out.println("\nCheck Out Booking");
        System.out.print("Enter booking number :: ");
        int bookingNumber = Integer.parseInt(input.nextLine());

        // searching and getting the booking with the given booking number        
        Booking booking = findBooking(bookingNumber);

        // if booking was found with the given booking number
        if (booking != null) {
            
            for (int i = 0; i < bookings.size(); i++) {
                if (bookings.get(i).getBookingNumber() == bookingNumber) {

                    // setting booked room back to available
                    bookings.get(i).getRoom().setBookedStatus(false);
                    bookings.remove(i);
                }
            }
        }
        else
            System.out.println("\nBooking not found!");
        waitForKeyEnter();
    }

    public void editBooking(Customers customers, Rooms rooms) {
        System.out.println("\nEdit booking");
        System.out.print("Enter booking number :: ");
        int bookingNumber = Integer.parseInt(input.nextLine());

        // searching and getting the booking with the given booking number        
        Booking booking = findBooking(bookingNumber);

        // if booking was found with the given booking number
        if (booking != null) {

            // getting and setting new customer
            Customer customer;
            do {
                System.out.print("\nEnter SSN of new customer :: ");
                String SSN = input.nextLine();
                customer = customers.findCustomer(SSN);
                if (customer != null)
                    booking.setCustomer(customer);
            } while (customer != null);
        
            // setting booked status of current room to false as it's going to be changed
            booking.getRoom().setBookedStatus(false);

            // getting and setting new room
            Room room;
            do {
                System.out.print("Enter number of new room :: ");
                int number = Integer.parseInt(input.nextLine());
                room = rooms.findRoom(number);
                if (room != null) {
                    room.setBookedStatus(true);
                    booking.setRoom(room);
                }
            } while (room != null);

            System.out.print("Enter new check-in date (DD-MM-YYYY) :: ");
            booking.setCheckInDate(new Date(input.nextLine()));
            System.out.print("Enter new check-out date (DD-MM-YYYY) :: ");
            booking.setCheckOutDate(new Date(input.nextLine()));
            
            booking.setStayPrice(booking.getRoom().getPricePerNight() * ((booking.getCheckOutDate().getTime() - booking.getCheckOutDate().getTime()) / (1000 * 60 * 60 * 24)));
            System.out.println("\nBooking Details Updated!");
        }
        else
            System.out.println("\nBooking not found!");
        waitForKeyEnter();
    }

    public void viewAllBookings() {
        System.out.println("\nAll Booking Details");

        // printing details of each booking
        for (Booking booking : bookings) {
            System.out.println("\nBooking number :: " + booking.getBookingNumber());
            System.out.println("Customer name :: " + booking.getCustomer().getFirstName() + " " + booking.getCustomer().getLastName());
            System.out.println("Room number :: " + booking.getRoom().getNumber());
            System.out.println("Stay price :: " + booking.getStayPrice());
            System.out.println("Check-in date :: " + booking.getCheckInDate());
            System.out.println("Check-out date :: " + booking.getCheckOutDate());
            System.out.println();
        }
        waitForKeyEnter();
    }

    private Booking findBooking(int bookingNumber) {
    	for (Booking booking : bookings) {
            if (booking.getBookingNumber() == bookingNumber)
                return booking;
    	}
    	return null;
    }

    private void waitForKeyEnter() {
        System.out.print("Press enter key to continue...");
        input.nextLine();
    }

}
package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Rooms {
    private final Scanner input;
    private final ArrayList<Room> rooms;

    public Rooms() {
        input = new Scanner(System.in);
        rooms = new ArrayList<>();
        // Adding rooms
        rooms.add(new Room(5,false,3,100.0));
        rooms.add(new Room(6,false,1,50.0));
        rooms.add(new Room(7,false,4,150.0));
        rooms.add(new Room(8,false,5,200.0));
    }
    
    public void addRoom() {
        System.out.println("\nAdd New Room");
        System.out.print("Enter room number :: ");
        int number = Integer.parseInt(input.nextLine());
        System.out.print("Enter number of beds in room :: ");
        int numberOfBeds = Integer.parseInt(input.nextLine());
        System.out.print("Enter price per night for room :: ");
        double pricePerNight = Double.parseDouble(input.nextLine());

        // adding new room to list of rooms
        rooms.add(new Room(number, false, numberOfBeds, pricePerNight));
        
        System.out.println("\nRoom Added!");
        waitForKeyEnter();
    }
    
    public void viewRoom() {
        System.out.println("\nView Room Details");
        System.out.print("Enter room number :: ");
        int number = Integer.parseInt(input.nextLine());

        // searching and getting the room details with the given room number
        Room room = findRoom(number);

        // if room was found with the given room number
        if (room != null) {
            System.out.println("\nRoom number :: " + room.getNumber());
            System.out.println("Room booked status :: " + room.isBookedStatus());
            System.out.println("Number of beds :: " + room.getNumberOfBeds());
            System.out.println("Room price per night :: " + room.getPricePerNight());
        }
        else
            System.out.println("\nRoom not found!");
        waitForKeyEnter();
    }

    public void editRoom() {
        System.out.println("\nEdit Room Details");
        System.out.print("Enter room number :: ");
        int number = Integer.parseInt(input.nextLine());

        // searching and getting the room with the given room number
        Room room = findRoom(number);

        // if room was found with the given room number
        if (room != null) {
	        System.out.print("\nEnter new number of beds in room :: ");
	        room.setNumberOfBeds(Integer.parseInt(input.nextLine()));
	        System.out.print("Enter new booked status (T/F) :: ");
	        room.setBookedStatus(input.nextLine().equalsIgnoreCase("t"));
	        System.out.print("Enter new price per night for room :: ");
	        room.setPricePerNight(Double.parseDouble(input.nextLine()));
            System.out.println("\nRoom Details Updated!");
        }
        else
            System.out.println("\nRoom not found!");
        waitForKeyEnter();
    }
	
    public void deleteRoom() {
        System.out.println("\nDelete Room");
        System.out.print("Enter room number :: ");
        int number = Integer.parseInt(input.nextLine());

        // searching and getting the room with the given room number
        Room room = findRoom(number);

        // if room was found with the given room number
        if (room != null) {
            for (int i = 0; i < rooms.size(); i++) {
                if (rooms.get(i).getNumber() == number) {
                    rooms.remove(i);
                    break;
                }
            }
            System.out.println("\nRoom Deleted!");
        }
        else
            System.out.println("\nRoom not found!");
        waitForKeyEnter();
    }
	
    public void viewAllRooms() {
        System.out.println("\nAll Rooms Details");

        // printing details of each room
        for (Room room : rooms) {
            System.out.println("\nRoom number :: " + room.getNumber());
            System.out.println("Room booked status :: " + room.isBookedStatus());
            System.out.println("Number of beds :: " + room.getNumberOfBeds());
            System.out.println("Room price per night :: " + room.getPricePerNight());
            System.out.println();
        }
        waitForKeyEnter();
    }
	
    public void viewAllAvailableRooms() {
        System.out.println("\nAll Available Rooms Details");

        // printing details of each available room
        for (Room room : rooms) {
            if (!room.isBookedStatus()) {
                System.out.println("\nRoom number :: " + room.getNumber());
                System.out.println("Room booked status :: " + room.isBookedStatus());
                System.out.println("Number of beds :: " + room.getNumberOfBeds());
                System.out.println("Room price per night :: " + room.getPricePerNight());
                System.out.println();
            }
        }
        waitForKeyEnter();
    }

    public Room findRoom(int number) {
        for (Room room : rooms) {
            if(room.getNumber() == number)
                return room;
        }
        return null;
    }
    
    private void waitForKeyEnter() {
        System.out.print("Press enter key to continue...");
        input.nextLine();
    }

}
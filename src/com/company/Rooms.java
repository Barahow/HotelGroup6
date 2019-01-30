package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Rooms {
    private final Scanner input;
    private final ArrayList<Room> rooms;

    public Rooms() {
        input = new Scanner(System.in);
        rooms = new ArrayList<>();
         // adding rooms
        rooms.add(new Room(5, false, 1, false, 50));
        rooms.add(new Room(6, false, 2, true, 150));
        rooms.add(new Room(7, false, 4, true, 200));

    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
    public ArrayList<Room> getAvailbleRooms() {
        ArrayList<Room>availableRooms = new ArrayList<>();
        for (Room room : rooms)
            if (!room.isBookedStatus())
                availableRooms.add(room);

        return availableRooms;
    }

    public void addRoom() {
        int number = 0;
        int numberofbeds = 0;
        double pricePerNight = 0;
        boolean hasbalcony = false;
        String choice;
        boolean a = true;
        boolean b = true;
        boolean c = true;
        boolean d = true;



        System.out.println("");
        if (a) {
            System.out.print("Enter room number: ");
            number = input.nextInt();

        } else {
            a = false;
        }
        if (b) {
            System.out.print("Enter number of beds: ");
            numberofbeds = input.nextInt();

        } else {
            b = false;
        }
        System.out.print("Does it have any balnconys (y/n)): ");
        choice = input.next();
        if (choice.equalsIgnoreCase("y")) {
            hasbalcony = true;

        } else if (choice.equalsIgnoreCase("n")) {
            hasbalcony = false;
        } else {
            System.out.println("try again");
        }
        if (c) {
            System.out.print("Enter Price per night: ");
            pricePerNight = input.nextDouble();
        } else {
            c = false;
        }
        if (d) {
            rooms.add(new Room(number, false, numberofbeds, hasbalcony, pricePerNight));

            System.out.println("\nRoom Added!");
            waitForKeyEnter();
        }
    }

        public void viewRoom () {
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
                System.out.println("room hasBalcony :: " + room.isHasBalcony());
                System.out.println("Room price per night :: " + room.getPricePerNight());

            } else
                System.out.println("\nRoom not found!");
            waitForKeyEnter();
        }

        public void editRoom () {
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
                System.out.println("Enter new HasBalcony status");
                room.setHasBalcony(input.nextLine().equalsIgnoreCase("t"));
            } else
                System.out.println("\nRoom not found!");
            waitForKeyEnter();
        }

        public void deleteRoom () {
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
            } else
                System.out.println("\nRoom not found!");
            waitForKeyEnter();
        }

        public void viewAllRooms () {
            System.out.println("\nAll Rooms Details");

            // printing details of each room
            for (Room room : rooms) {
                System.out.println("\nRoom number :: " + room.getNumber());
                System.out.println("Room booked status :: " + room.isBookedStatus());
                System.out.println("Number of beds :: " + room.getNumberOfBeds());
                System.out.println("room hasBlancony :: " + room.isHasBalcony());
                System.out.println("Room price per night :: " + room.getPricePerNight());

                System.out.println();
            }
            waitForKeyEnter();
        }

        public void viewAllAvailableRooms () {
            System.out.println("\nAll Available Rooms Details");

            // printing details of each available room
            for (Room room : rooms) {
                if (!room.isBookedStatus()) {
                    System.out.println("\nRoom number :: " + room.getNumber());
                    System.out.println("Room booked status :: " + room.isBookedStatus());
                    System.out.println("Number of beds :: " + room.getNumberOfBeds());
                    System.out.println("room hasBlancony ::: " + room.isHasBalcony());
                    System.out.println("Room price per night :: " + room.getPricePerNight());

                    System.out.println();
                }
            }
            waitForKeyEnter();
        }

        public Room findRoom ( int number){
            for (Room room : rooms) {
                if (room.getNumber() == number)
                    return room;
            }
            return null;
        }

        private void waitForKeyEnter () {
            System.out.print("Press enter key to continue...");
            input.nextLine();
        }

    }


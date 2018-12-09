package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Hotellogic {
    private Scanner input;
    private Room room;


    public Hotellogic() {
        this.input = new Scanner(System.in);
        this.room = new Room(20,2,2);

        initiateRooms();
    }

    private ArrayList<Room> rooms = new ArrayList<>();

    private int menu() {

        System.out.println("-----Welcome to hotel management----");
        System.out.println("(1)----Add Customer-------");
        System.out.println("(2)----List of all customers---------");
        System.out.println("(3) ----Book a room ----------");
        System.out.println("(0)------Exit--------");

        int choice = readInt(0, 4);

        return choice;
    }

    public void start() {
        while (true) {

            int choice = menu();
            switch (choice) {

                case 0:
                    System.exit(0);

                    break;
                case 1:
                    addCustomer();

                    break;
                case 2:
                    showAll();

                    break;
                case 3:
                    printRooms();

                    break;


                default:
                    throw new AssertionError();
            }

        }

    }

    private void showAll() {
        System.out.println("---All Customer----");
        System.out.println("id\t Name\t SSN\t Address\t");
        for (int i = 0; i < this.room.count(); i++) {
            Customer c = this.room.getcustomer(i);
            System.out.println(c.getId() + "\n" + c.getName() + "\t" + c.getSsn() + "\t" + c.getAddress());

        }
    }

    private void addCustomer() {
        System.out.println("Enter ID ");
        int id = readInt(0, Integer.MAX_VALUE);

        System.out.println("Enter Customer name:");
        String name = input.nextLine();
        System.out.println("Enter Customer ssn");
        String ssn = input.nextLine();
        System.out.println("Enter Customer address");
        String address = input.nextLine();

        Customer c = new Customer( id, name, ssn, address);
        this.room.addCustomer(c);





    }

    private int readInt(int min, int max) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(input.nextLine());

                if (choice >= min && choice <= max) {
                    break;
                }

            } catch (Exception e) {
                e.printStackTrace();

            }


        }
        return choice;
    }

    public void bookRoom(int roomNumber) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomNumber() == roomNumber) {
                rooms.get(i).setBooked(true);
                rooms.get(i).getcustomer(i);
            }
        }
    }

    public void unBookRoom(int roomNumber) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomNumber() == roomNumber) {
                rooms.get(i).setBooked(false);
            }
        }
    }

    public void addRoom(int roomNumber, int size, int beds) {
        rooms.add(new Room(roomNumber, size, beds));

    }

    public void initiateRooms() {
        rooms.add(new Room(1, 25, 2));
        rooms.add(new Room(2, 30, 4));
        rooms.add(new Room(10, 20, 1));
        rooms.add(new Room(11, 20, 1));
        rooms.add(new Room(12, 20, 1));
        rooms.add(new Room(13, 20, 1));
    }

    public void removeRoom(int roomNumber) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomNumber() == roomNumber) {
                rooms.remove(i);
            }
        }
    }

    public int getEmptyRooms() {
        int emptyRooms = 0;
        for (int i = 0; i < rooms.size(); i++) {
            if (!rooms.get(i).getBooked()) {
                emptyRooms++;
            }
        }
        return emptyRooms;
    }

    public int getBookedRooms() {
        int bookedrooms = 0;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getBooked()) {
                bookedrooms++;
            }
        }

        return bookedrooms;
    }

    public ArrayList getRooms() {
        return rooms;
    }

    private void printRooms() {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to our hotel");

        Hotellogic kingsHouse = new Hotellogic();


        System.out.println("Do you want to book a room?");
        String answer = input.nextLine();


        if (answer.equalsIgnoreCase("yes")) {


            System.out.println("We have " + kingsHouse.getEmptyRooms() + " empty rooms.");
            for (int i = 0; i < kingsHouse.getRooms().size(); i++) {
                Room room = ((Room) kingsHouse.getRooms().get(i));
                if (!room.getBooked()) {
                    System.out.println("Room number: " + room.getRoomNumber()
                            + "\nBeds: " + room.getBeds()
                            + "\nSize: " + room.getSize()
                            + "\nBooked: " + room.getBooked());
                }
            }
            System.out.println("Which room do you want?");
            int roomNumber = input.nextInt();
            kingsHouse.bookRoom(roomNumber);
            System.out.println("Your room is booked!");
        }
    }
}







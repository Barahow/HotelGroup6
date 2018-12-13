package se.hkr;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);



        Hotel kingsHouse = new Hotel();

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
         kingsHouse.removeRoom(9);

       kingsHouse.bookRoom(1);
        kingsHouse.bookRoom(2);

        kingsHouse.unBookRoom(2);

        kingsHouse.getBookedRooms();


/*
        System.out.println("These are all rooms: " + kingsHouse.getRooms().size());
        for (int i = 0; i < kingsHouse.getRooms().size(); i++) {
            Room room = ((Room) kingsHouse.getRooms().get(i));
            System.out.println("Room number: " + room.getRoomNumber()
                    + "\nBeds: " + room.getBeds()
                    + "\nSize: " + room.getSize()
                    + "\nBooked: " + room.getBooked());
        }
        System.out.println("Number of rooms booked: \n"+ kingsHouse.getBookedRooms() );*/
    }
}

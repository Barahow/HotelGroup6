package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Hotellogic ht = new Hotellogic();
        ht.start();
        ht.initiateRooms();



    }
}














/*        kingsHouse.bookRoom(1);
        kingsHouse.bookRoom(2);
        kingsHouse.unBookRoom(2);
        kingsHouse.getBookedRooms();
        System.out.println("These are all rooms: " + kingsHouse.getRooms().size());
        for (int i = 0; i < kingsHouse.getRooms().size(); i++) {
            Room room = ((Room) kingsHouse.getRooms().get(i));
            System.out.println("Room number: " + room.getRoomNumber()
                    + "\nBeds: " + room.getBeds()
                    + "\nSize: " + room.getSize()
                    + "\nBooked: " + room.getBooked());
        }
        System.out.println("Number of rooms booked: \n"+ kingsHouse.getBookedRooms() );*/


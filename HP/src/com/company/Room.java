package com.company;

import java.util.ArrayList;
import java.util.List;

public class Room {


    private List<Customer> listOfCustomers;


    private static int idCounter = 0;
    private final int roomId = ++idCounter;
    private int roomNumber;
    private int numberOfBeds;
    private boolean hasBalcony;
    private double pricePerNight;
    private boolean isBooked = false;

    public Room(int roomNumber, int numberOfBeds, boolean hasBalcony,
                double pricePerNight) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.hasBalcony = hasBalcony;
        this.pricePerNight = pricePerNight;
        this.listOfCustomers = new ArrayList<>();

    } public int addCustomer(Customer c){
        this.listOfCustomers.add( c );
      return count();

    } public int count (){
        return this.listOfCustomers.size();

    }
    public Customer getCustomer(int index) {
        if (index <0|| index >= count()) {
            return null;
        }
    return this.listOfCustomers.get( index );
    }

    public Room(int roomNumber, int size, int beds) {
    }

    public int getRoomNumber() {return roomNumber;}
    public int getNumberOfBeds() {return numberOfBeds;}
    public boolean isHasBalcony() {return hasBalcony;}
    public double getPricePerNight() {return pricePerNight;}
    public boolean isBooked() {return isBooked;}
    public void setBooked(boolean isBooked) {this.isBooked = isBooked;}

}




package com.company;

import java.util.ArrayList;
import java.util.List;

public class Room  {

    private List<Customer> list0fCustomers;
    private int roomNumber;
    private int size;
    private int beds;
    private boolean booked;

    public Room(int roomNumber, int size, int beds) {
        this.roomNumber = roomNumber;
        this.size = size;
        this.beds = beds;
        booked = false;
        this.list0fCustomers = new ArrayList<>();

    }
    public int addCustomer(Customer c) {
        this.list0fCustomers.add(c);

        return count();


    }

    public int count() {

        return this.list0fCustomers.size();


    }
    public Customer getcustomer(int index) {
        if (index < 0 || index >= count()) {
            return null;
        }
        return this.list0fCustomers.get(index);
    }



public int getRoomNumber() {
        return roomNumber;
    }

    public int getSize() {
        return size;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getBeds() {
        return beds;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public boolean getBooked() {
        return booked;
    }
}

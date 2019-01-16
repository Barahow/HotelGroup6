package com.company;

import java.util.Date;

public class Booking {

    private int bookingNumber;
    private Customer customer;
    private Room room;
    private double stayPrice;
    private Date checkInDate;
    private Date checkOutDate;

    public Booking(int bookingNumber, Customer customer, Room room, Date checkInDate, Date checkOutDate) {
        this.bookingNumber = bookingNumber;
        this.customer = customer;
        this.room = room;
        this.stayPrice = room.getPricePerNight() * ((checkOutDate.getTime() - checkInDate.getTime()) / (1000 * 60 * 60 * 24));
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public double getStayPrice() {
        return stayPrice;
    }

    public void setStayPrice(double stayPrice) {
        this.stayPrice = stayPrice;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

}
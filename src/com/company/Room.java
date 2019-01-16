package com.company;

public class Room {

    private int number;
    private boolean bookedStatus;
    private int numberOfBeds;
    private boolean hasBalcony;
    private double pricePerNight;

    public Room(int number, boolean bookedStatus, int numberOfBeds, boolean hasBalcony, double pricePerNight) {
        this.number = number;
        this.bookedStatus = bookedStatus;
        this.numberOfBeds = numberOfBeds;
        this.hasBalcony = hasBalcony;
        this.pricePerNight = pricePerNight;

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isBookedStatus() {
        return bookedStatus;
    }

    public void setBookedStatus(boolean bookedStatus) {
        this.bookedStatus = bookedStatus;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }
}
package se.hkr;

public class Room {

    private  int roomNumber;
    private  int size;
    private  int beds;
    private  boolean booked;

    public Room(int roomNumber, int size, int beds){
        this.roomNumber= roomNumber;
        this.size = size;
        this.beds = beds;
        booked = false;
        System.out.println("test bash");

    }

    public int getRoomNumber(){
        return roomNumber;
    }

    public int getSize(){
        return size;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getBeds(){
        return beds;
    }

    public void setBooked(boolean booked){
        this.booked = booked;
    }

    public boolean getBooked(){
        return booked;
    }

















}
package se.hkr;

import java.util.ArrayList;

public class Hotel {

    /*public Hotel() {
        initiateRooms();
    }*/

    private ArrayList<Room> rooms = new ArrayList<>();

    public void bookRoom (int roomNumber) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomNumber() == roomNumber) {
                rooms.get(i).setBooked(true);
            }
        }
    }

    public void unBookRoom (int roomNumber ){
        for (int i = 0; i < rooms.size(); i++){
            if (rooms.get(i).getRoomNumber() == roomNumber){
                rooms.get(i).setBooked(false);
            }
        }
    }

    public void addRoom (int roomNumber, int size, int beds) {
        rooms.add(new Room(roomNumber,size,beds));
    }
    private void initiateRooms() {
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
       for (int i = 0; i < rooms.size();i++){
           if (rooms.get(i).getBooked()){
               bookedrooms++;
           }
       }

        return bookedrooms;
    }

    public ArrayList getRooms() {
        return rooms;
    }
}

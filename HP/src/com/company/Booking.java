package com.company;

import java.util.Scanner;

public class Booking
{
    static RoomDB roomDB = new RoomDB();

    public static void main(String[] args) {
        String roomID;
        Room room;
        Scanner inputID = new Scanner(System.in);

        while(true){

            System.out.println("Please choose the room you want to book \n"+getRoomList(roomDB));

            while(true){
                roomID = inputID.nextLine();
                if(roomID.equals ("x")){
                    break;
                }

                if(getRoom(roomID) == null){

                    System.out.println("The room ID is incorrect, please enter again or enter x to quit");

                }
                else{

                    room = getRoom(roomID);

                    if(!room.isBooked()){
                        System.out.println("Book successfully");
                        break;
                    }
                    else{
                        System.out.println("please enter the room ID again or enter x to quit");
                    }
                }

            }

        }

    }

    public static String getRoomList(RoomDB roomDB)
    {

        String roomList = "";
        for(Room r:roomDB.getRoom())
        {

            if(!r.isBooked())
            {
                roomList = roomList+r.getRoomID()+" is free"+"   ";
            }
            else
            {
                roomList = roomList+r.getRoomID()+" has been booked ";
            }

        }
        return roomList;
    }


    public static Room getRoom(String roomID){

        for(Room r:roomDB.getRoom()){

            if(r.getRoomID()==roomID){

                return r;

            }

        }
        return null;

    }
}

public class RoomDB
{
    private ArrayList<Room> room;
    private String[] roomID = {"Room1","Room2"};

    RoomDB(){

        room = new ArrayList<Room>();
        for(int i=0;i<roomID.length;i++)
        {
            addRoom(new Room(roomID[i]));
        }

    }

    public void addRoom(Room addRoom){
        room.add(addRoom);
    }

    public ArrayList<Room> getRoom(){
        return room;
    }
}
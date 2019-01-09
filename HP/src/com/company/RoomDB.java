package com.company;

import java.util.ArrayList;

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

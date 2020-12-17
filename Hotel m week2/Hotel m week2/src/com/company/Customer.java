package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Customer  {

    private int id;
    private List<Room> list0fRooms;
    private String name;
    private String ssn;
    private String address;

    public Customer( int id, String name, String ssn, String address) {
        this.list0fRooms = list0fRooms;
        this.name = name;
        this.ssn = ssn;
        this.address = address;
        this.id = id;
    }





    public int addroom(Room r) {
        this.list0fRooms.add(r);


        return count();

    }

    public int count() {

        return this.list0fRooms.size();


    }

    public Room getroom (int index) {
        if (index < 0 || index >= count()) {
            return null;
        }
        return this.list0fRooms.get(index);
    }


    public String getName() {
        return name;
    }

    public String getSsn() {
        return ssn;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Room> getList0fRooms() {
        return list0fRooms;
    }

    public void setList0fRooms(List<Room> list0fRooms) {
        this.list0fRooms = list0fRooms;
    }
}

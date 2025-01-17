package com.hotelmanagement;

import java.util.List;

public class UserService {
    private Hotel hotel;

    public UserService(Hotel hotel) {
        this.hotel = hotel;
    }

    public void displayAllRooms() {
        System.out.println("Lista wszystkich pokoi:");
        for (Room room : hotel.getAllRooms()) {
            System.out.println(room);
        }
    }

    public void displayAvailableRooms() {
        System.out.println("Lista dostępnych pokoi:");
        for (Room room : hotel.getAvailableRooms()) {
            System.out.println(room);
        }
    }

    public void reserveRoom(int roomNumber, List<Guest> guests) {
        if (hotel.reserveRoom(roomNumber, guests)) {
            System.out.println("Pokój " + roomNumber + " został zarezerwowany.");
        } else {
            System.out.println("Nie można zarezerwować pokoju " + roomNumber + ".");
        }
    }

    public void releaseRoom(int roomNumber) {
        if (hotel.releaseRoom(roomNumber)) {
            System.out.println("Pokój " + roomNumber + " został zwolniony.");
        } else {
            System.out.println("Nie można zwolnić pokoju " + roomNumber + ".");
        }
    }

    public void displayRoomsToClean() {
        System.out.println("Lista pokoi do posprzątania:");
        for (Room room : hotel.getRoomsToClean()) {
            System.out.println(room);
        }
    }

    public void cleanRoom(int roomNumber) {
        hotel.cleanRoom(roomNumber);
        System.out.println("Pokój " + roomNumber + " został posprzątany.");
    }
}

package com.hotelmanagement;

import java.util.ArrayList;
import java.util.List;

public class Room {
    int roomNumber;
    int capacity;
    boolean hasBathroom;
    boolean isAvailable;
    boolean isCleaned; // Nowy parametr: czy pokój jest posprzątany
    List<Guest> guests; // Lista gości w pokoju

    public Room(int roomNumber, int capacity, boolean hasBathroom) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.hasBathroom = hasBathroom;
        this.isAvailable = true;
        this.isCleaned = true; // Domyślnie pokój jest posprzątany
        this.guests = new ArrayList<>();
    }

    public void reserveRoom(List<Guest> guests) {
        this.isAvailable = false;
        this.isCleaned = false;
        this.guests = guests;
    }

    public void releaseRoom() {
        this.isAvailable = true;
        this.isCleaned = false; // Po zwolnieniu pokój wymaga sprzątania
        this.guests.clear();
    }

    @Override
    public String toString() {
        return "Pokój " + roomNumber + ", Ilość osób: " + capacity +
                ", Łazienka: " + (hasBathroom ? "Tak" : "Nie") +
                ", Dostępny: " + (isAvailable ? "Tak" : "Nie") +
                ", Posprzątany: " + (isCleaned ? "Tak" : "Nie");
    }
}

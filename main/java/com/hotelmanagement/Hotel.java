package com.hotelmanagement;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    List<Room> rooms;

    public Hotel() {
        rooms = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            rooms.add(new Room(i, (i % 4) + 1, i % 2 == 0));
        }
    }

    public List<Room> getAllRooms() {
        return rooms;
    }

    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable && room.isCleaned) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public boolean reserveRoom(int roomNumber, List<Guest> guests) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber && room.isAvailable && room.isCleaned) {
                boolean hasAdult = guests.stream().anyMatch(Guest::isAdult);
                if (hasAdult) {
                    room.reserveRoom(guests);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean releaseRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber && !room.isAvailable) {
                room.releaseRoom();
                return true;
            }
        }
        return false;
    }

    public List<Room> getRoomsToClean() {
        List<Room> dirtyRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (!room.isCleaned) {
                dirtyRooms.add(room);
            }
        }
        return dirtyRooms;
    }

    public void cleanRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber && !room.isCleaned) {
                room.isCleaned = true;
            }
        }
    }
}

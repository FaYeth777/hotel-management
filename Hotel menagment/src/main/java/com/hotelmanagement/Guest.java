package com.hotelmanagement;

import java.time.LocalDate;

public class Guest {
    String firstName;
    String lastName;
    LocalDate birthDate;

    public Guest(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public boolean isAdult() {
        return LocalDate.now().minusYears(18).isAfter(birthDate);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", Data urodzenia: " + birthDate;
    }
}

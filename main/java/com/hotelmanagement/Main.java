package com.hotelmanagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        UserService userService = new UserService(hotel);
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Hotel Management ---");
            System.out.println("1. Wyświetl listę pokoi");
            System.out.println("2. Wyświetl dostępne pokoje");
            System.out.println("3. Zarezerwuj pokój");
            System.out.println("4. Zwolnij pokój");
            System.out.println("5. Wyświetl listę pokoi do posprzątania");
            System.out.println("6. Posprzątaj pokój");
            System.out.println("7. Wyjdź");
            System.out.print("Wybierz opcję: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    userService.displayAllRooms();
                    break;
                case 2:
                    userService.displayAvailableRooms();
                    break;
                case 3:
                    System.out.print("Podaj numer pokoju do zarezerwowania: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine(); // Konsumuje nową linię

                    List<Guest> guests = new ArrayList<>();
                    System.out.print("Podaj liczbę gości: ");
                    int numGuests = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < numGuests; i++) {
                        System.out.print("Imię: ");
                        String firstName = scanner.nextLine();
                        System.out.print("Nazwisko: ");
                        String lastName = scanner.nextLine();
                        System.out.print("Data urodzenia (YYYY-MM-DD): ");
                        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
                        guests.add(new Guest(firstName, lastName, birthDate));
                    }
                    userService.reserveRoom(roomNumber, guests);
                    break;
                case 4:
                    System.out.print("Podaj numer pokoju do zwolnienia: ");
                    userService.releaseRoom(scanner.nextInt());
                    break;
                case 5:
                    userService.displayRoomsToClean();
                    break;
                case 6:
                    System.out.print("Podaj numer pokoju do posprzątania: ");
                    userService.cleanRoom(scanner.nextInt());
                    break;
                case 7:
                    System.out.println("Wyjście z programu.");
                    break;
                default:
                    System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
            }
        } while (choice != 7);

        scanner.close();
    }
}

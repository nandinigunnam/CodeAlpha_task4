package codeAlpha;
import java.util.Scanner;

public class HotelReservationSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean[][] rooms = new boolean[3][10]; // Assuming 3 types of rooms and 10 rooms each
    private static double[] roomPrices = {100.0, 150.0, 200.0}; // Prices for each room type

    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation System!");

        while (true) {
            System.out.println("1. Search Available Rooms");
            System.out.println("2. Make Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    searchAvailableRooms();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    viewBookingDetails();
                    break;
                case 4:
                    System.out.println("Thank you for using Hotel Reservation System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void searchAvailableRooms() {
        System.out.println("Available Rooms:");
        for (int i = 0; i < rooms.length; i++) {
            System.out.println("Room Type " + (i + 1) + ":");
            for (int j = 0; j < rooms[i].length; j++) {
                if (!rooms[i][j]) {
                    System.out.println("Room " + (j + 1) + ": Available - $" + roomPrices[i]);
                }
            }
            System.out.println();
        }
    }

    private static void makeReservation() {
        System.out.print("Enter room type to reserve (1, 2, or 3): ");
        int roomType = scanner.nextInt();
        System.out.print("Enter room number to reserve: ");
        int roomNumber = scanner.nextInt();
        if (roomType < 1 || roomType > rooms.length || roomNumber < 1 || roomNumber > rooms[roomType - 1].length) {
            System.out.println("Invalid room type or number.");
            return;
        }

        if (rooms[roomType - 1][roomNumber - 1]) {
            System.out.println("Room " + roomNumber + " of type " + roomType + " is already booked.");
        } else {
            rooms[roomType - 1][roomNumber - 1] = true;
            double totalPrice = roomPrices[roomType - 1];
            System.out.println("Room " + roomNumber + " of type " + roomType + " booked successfully. Total price: $" + totalPrice);
            System.out.println("Proceed to payment...");
            processPayment(totalPrice);
        }
    }

    private static void viewBookingDetails() {
        System.out.println("Booking Details:");
        for (int i = 0; i < rooms.length; i++) {
            System.out.println("Room Type " + (i + 1) + ":");
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j]) {
                    System.out.println("Room " + (j + 1) + ": Booked - $" + roomPrices[i]);
                }
            }
            System.out.println();
        }
    }

    private static void processPayment(double totalPrice) {
        // Placeholder for payment processing
        System.out.println("Payment of $" + totalPrice + " processed successfully.");
    }
}
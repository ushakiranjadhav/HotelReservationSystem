package ReservationSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);

        // Adding some rooms
        hotel.addRoom(new Room(101, "Single", 100.0));
        hotel.addRoom(new Room(102, "Double", 150.0));
        hotel.addRoom(new Room(103, "Suite", 200.0));

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        while (true) {
            System.out.println("Choose an option: ");
            System.out.println("1. Search available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. View reservations");
            System.out.println("4. Exit");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Enter room category (Single/Double/Suite): ");
                    String category = scanner.nextLine();
                    hotel.searchAvailableRooms(category);
                    break;
                case "2":
                    System.out.println("Enter guest name: ");
                    String guestName = scanner.nextLine();
                    System.out.println("Enter room number: ");
                    int roomNumber = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter check-in date (dd-MM-yyyy): ");
                    Date checkInDate = null;
                    try {
                        checkInDate = dateFormat.parse(scanner.nextLine());
                    } catch (ParseException e) {
                        System.out.println("Invalid date format.");
                        break;
                    }
                    System.out.println("Enter check-out date (dd-MM-yyyy): ");
                    Date checkOutDate = null;
                    try {
                        checkOutDate = dateFormat.parse(scanner.nextLine());
                    } catch (ParseException e) {
                        System.out.println("Invalid date format.");
                        break;
                    }
                    System.out.println("Enter payment method (Credit Card/PayPal): ");
                    String paymentMethod = scanner.nextLine();
                    double amount = 0.0;
                    for (Room room : hotel.getRooms()) {
                        if (room.getRoomNumber() == roomNumber) {
                            amount = room.getPrice() * (checkOutDate.getTime() - checkInDate.getTime()) / (1000 * 60 * 60 * 24);
                            break;
                        }
                    }
                    Payment payment = new Payment(amount, paymentMethod);
                    hotel.makeReservation(guestName, roomNumber, checkInDate, checkOutDate, payment);
                    break;
                case "3":
                    hotel.viewReservations();
                    break;
                case "4":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }

	}

}

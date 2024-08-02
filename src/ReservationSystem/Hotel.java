package ReservationSystem;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Hotel {
	private List<Room> rooms;
    private List<Reservation> reservations;

    public Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void makeReservation(String guestName, int roomNumber, Date checkInDate, Date checkOutDate, Payment payment) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                payment.processPayment();
                if (payment.isPaymentStatus()) {
                    Reservation reservation = new Reservation(room, guestName, checkInDate, checkOutDate, payment);
                    reservations.add(reservation);
                    System.out.println("Reservation made for " + guestName);
                } else {
                    System.out.println("Payment failed. Reservation not made.");
                }
                return;
            }
        }
        System.out.println("Room not available or does not exist.");
    }

    public void viewReservations() {
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }

    public void searchAvailableRooms(String category) {
        for (Room room : rooms) {
            if (room.getCategory().equalsIgnoreCase(category) && room.isAvailable()) {
                System.out.println(room);
            }
        }
    }
    public List<Room> getRooms() {
        return rooms;
    }


}

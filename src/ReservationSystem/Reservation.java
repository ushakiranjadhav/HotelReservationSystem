package ReservationSystem;
import java.util.Date;
public class Reservation {
	private Room room;
    private String guestName;
    private Date checkInDate;
    private Date checkOutDate;
    private Payment payment;

    public Reservation(Room room, String guestName, Date checkInDate, Date checkOutDate, Payment payment) {
        this.room = room;
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.payment = payment;
        room.setAvailable(false);
    }

    public Room getRoom() {
        return room;
    }

    public String getGuestName() {
        return guestName;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public Payment getPayment() {
        return payment;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "room=" + room +
                ", guestName='" + guestName + '\'' +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", payment=" + payment.getAmount() + " " + payment.getPaymentMethod() + " " + (payment.isPaymentStatus() ? "Completed" : "Pending") +
                '}';
    }

}

import java.time.LocalDateTime;
import java.time.Duration;

public class ParkingTicket {
    private final long ticketId;
    private final String regNo;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public ParkingTicket(long ticketId, String regNo) { this(ticketId, regNo, LocalDateTime.now()); }
    public ParkingTicket(long ticketId, String regNo, LocalDateTime entryTime) {
        if (ticketId <= 0 || regNo == null || regNo.isBlank() || entryTime == null)
            throw new IllegalArgumentException("Invalid ticket data");
        this.ticketId = ticketId; this.regNo = regNo; this.entryTime = entryTime;
    }
    public long getTicketId() { return ticketId; }
    public String getRegNo() { return regNo; }
    public void closeTicket(LocalDateTime exitTime) {
        if (exitTime == null || exitTime.isBefore(entryTime)) throw new IllegalArgumentException("Invalid exit time");
        this.exitTime = exitTime;
    }
    public long durationMinutes() {
        if (exitTime == null) throw new IllegalStateException("Ticket is still active");
        return Duration.between(entryTime, exitTime).toMinutes();
    }
    public static void main(String[] args) {
        ParkingTicket t = new ParkingTicket(101, "TN01AB1111", LocalDateTime.of(2026, 1, 1, 9, 0));
        t.closeTicket(LocalDateTime.of(2026, 1, 1, 10, 30));
        System.out.println("Ticket ID: " + t.getTicketId());
        System.out.println("Vehicle Number: " + t.getRegNo());
        System.out.println("Duration: " + t.durationMinutes() + " minutes");
    }
}

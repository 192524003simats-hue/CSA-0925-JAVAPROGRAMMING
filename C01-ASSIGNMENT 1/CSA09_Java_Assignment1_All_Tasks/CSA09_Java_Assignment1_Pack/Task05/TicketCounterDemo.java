class Ticket {
    private static long nextId = 1000;
    private final long id;
    Ticket() { id = ++nextId; }
    long getId() { return id; }
}
public class TicketCounterDemo {
    public static void main(String[] args) {
        Ticket a = new Ticket(); Ticket b = new Ticket();
        System.out.println("Ticket A: " + a.getId());
        System.out.println("Ticket B: " + b.getId());
    }
}

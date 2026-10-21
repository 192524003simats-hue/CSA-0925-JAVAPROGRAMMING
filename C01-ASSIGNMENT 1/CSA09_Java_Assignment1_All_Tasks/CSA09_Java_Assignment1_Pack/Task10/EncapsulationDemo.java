class ParkingSlot {
    private final int floor;
    private final int slot;
    private String regNo;
    ParkingSlot(int floor, int slot) {
        if (floor < 0 || slot < 0) throw new IllegalArgumentException("Invalid slot");
        this.floor = floor; this.slot = slot;
    }
    public boolean park(String regNo) {
        if (regNo == null || regNo.isBlank() || this.regNo != null) return false;
        this.regNo = regNo; return true;
    }
    public String getRegNo() { return regNo; }
    public int getFloor() { return floor; }
    public int getSlot() { return slot; }
}
public class EncapsulationDemo {
    public static void main(String[] args) {
        ParkingSlot s = new ParkingSlot(0, 1);
        System.out.println(s.park("TN01AB1111"));
        System.out.println(s.park("TN02CD2222"));
        System.out.println("Parked: " + s.getRegNo());
    }
}

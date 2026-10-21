import java.util.*;
abstract class Vehicle {
    final String regNo;
    Vehicle(String regNo) { if (regNo == null || regNo.isBlank()) throw new IllegalArgumentException("Invalid registration"); this.regNo = regNo; }
    abstract double ratePerHour();
    double fee(int minutes) { if (minutes < 0) throw new IllegalArgumentException("Negative duration"); return ((minutes + 59) / 60) * ratePerHour(); }
}
class Car extends Vehicle { Car(String r) { super(r); } double ratePerHour() { return 30; } }
class Bike extends Vehicle { Bike(String r) { super(r); } double ratePerHour() { return 10; } }
class ParkingSystem {
    private final String[][] slots;
    private final Map<String, Vehicle> active = new HashMap<>();
    ParkingSystem(int[] perFloor) { slots = new String[perFloor.length][]; for(int i=0;i<perFloor.length;i++) slots[i]=new String[perFloor[i]]; }
    int[] enter(Vehicle v) {
        if(active.containsKey(v.regNo)) throw new IllegalArgumentException("Duplicate registration");
        for(int f=0;f<slots.length;f++) for(int s=0;s<slots[f].length;s++) if(slots[f][s]==null) { slots[f][s]=v.regNo; active.put(v.regNo,v); return new int[]{f,s}; }
        return null;
    }
    boolean leave(String regNo, int minutes) {
        Vehicle v=active.get(regNo); if(v==null) return false;
        System.out.println(regNo + " fee: Rs " + v.fee(minutes));
        for(int f=0;f<slots.length;f++) for(int s=0;s<slots[f].length;s++) if(regNo.equals(slots[f][s])) { slots[f][s]=null; active.remove(regNo); return true; }
        return false;
    }
}
public class ParkingSystemDemo {
    public static void main(String[] args) {
        ParkingSystem p = new ParkingSystem(new int[]{1,1});
        System.out.println("Car slot: " + Arrays.toString(p.enter(new Car("TN01AB1111"))));
        System.out.println("Bike slot: " + Arrays.toString(p.enter(new Bike("TN02CD2222"))));
        System.out.println("Full facility: " + p.enter(new Car("TN03EF3333")));
        p.leave("TN01AB1111", 61);
        System.out.println("Invalid registration found: " + p.leave("UNKNOWN", 30));
    }
}

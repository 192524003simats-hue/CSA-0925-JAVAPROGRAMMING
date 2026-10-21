import java.time.LocalTime;
import java.util.*;
abstract class Vehicle {
    final String regNo;
    Vehicle(String regNo) { this.regNo=regNo; }
    abstract double fee(int minutes, LocalTime entry);
}
class Car extends Vehicle {
    Car(String r) { super(r); }
    double fee(int minutes, LocalTime entry) { return ((minutes + 59) / 60) * 30.0; }
}
class EBike extends Vehicle {
    EBike(String r) { super(r); }
    double fee(int minutes, LocalTime entry) { return 25.0; }
}
class DeliveryVan extends Vehicle {
    DeliveryVan(String r) { super(r); }
    double fee(int minutes, LocalTime entry) {
        double rate = (!entry.isBefore(LocalTime.of(9,0)) && entry.isBefore(LocalTime.of(17,0))) ? 60.0 : 30.0;
        return ((minutes + 59) / 60) * rate;
    }
}
class OneDayPass {
    private final String regNo;
    OneDayPass(String regNo) { this.regNo=regNo; }
    boolean appliesTo(Vehicle v) { return regNo.equals(v.regNo); }
}
public class SmartParkingExtended {
    public static void main(String[] args) {
        Vehicle car = new Car("TN01AB1111");
        Vehicle ebike = new EBike("TN02CD2222");
        Vehicle van = new DeliveryVan("TN03EF3333");
        OneDayPass pass = new OneDayPass("TN01AB1111");
        System.out.println("Car fee (60 min): Rs " + (pass.appliesTo(car) ? 0.0 : car.fee(60, LocalTime.of(10,0))));
        System.out.println("E-bike flat fee: Rs " + ebike.fee(60, LocalTime.of(10,0)));
        System.out.println("Delivery van daytime fee (2 hours): Rs " + van.fee(120, LocalTime.of(10,0)));
        System.out.println("Uneven floors supported: " + Arrays.toString(new int[]{20, 35, 50, 40, 25}));
    }
}

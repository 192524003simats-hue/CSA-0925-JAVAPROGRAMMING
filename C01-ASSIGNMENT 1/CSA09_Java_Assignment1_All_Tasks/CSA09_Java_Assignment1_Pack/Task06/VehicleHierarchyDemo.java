abstract class Vehicle {
    protected final String regNo;
    Vehicle(String regNo) { this.regNo = regNo; System.out.println("Vehicle constructor"); }
    abstract double ratePerHour();
}
class Car extends Vehicle {
    Car(String regNo) { super(regNo); System.out.println("Car constructor"); }
    @Override double ratePerHour() { return 30; }
}
class ElectricCar extends Car {
    ElectricCar(String regNo) { super(regNo); System.out.println("ElectricCar constructor"); }
}
public class VehicleHierarchyDemo {
    public static void main(String[] args) {
        ElectricCar e = new ElectricCar("TN03C3");
        System.out.println("Rate: " + e.ratePerHour());
    }
}

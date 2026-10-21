interface Chargeable { double chargingFee(int kWh); }
abstract class Vehicle {
    private final String regNo;
    Vehicle(String regNo) { this.regNo = regNo; }
    String getRegNo() { return regNo; }
    abstract double ratePerHour();
}
class ElectricCar extends Vehicle implements Chargeable {
    ElectricCar(String regNo) { super(regNo); }
    @Override double ratePerHour() { return 30; }
    @Override public double chargingFee(int kWh) { return kWh * 12.0; }
}
public class AbstractionDemo {
    public static void main(String[] args) {
        ElectricCar car = new ElectricCar("TN03C3");
        System.out.println("Registration: " + car.getRegNo());
        System.out.println("Hourly rate: " + car.ratePerHour());
        System.out.println("Charging fee: " + car.chargingFee(5));
    }
}

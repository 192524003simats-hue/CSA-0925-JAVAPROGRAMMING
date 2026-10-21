import java.util.Objects;
class Vehicle {
    private final String regNo;
    Vehicle(String regNo) { this.regNo = regNo; }
    @Override public String toString() { return "Vehicle(" + regNo + ")"; }
    @Override public boolean equals(Object o) { return o instanceof Vehicle v && regNo.equals(v.regNo); }
    @Override public int hashCode() { return Objects.hash(regNo); }
}
public class VehicleEqualityDemo {
    public static void main(String[] args) {
        Vehicle a = new Vehicle("TN01AB1111"); Vehicle b = new Vehicle("TN01AB1111");
        System.out.println(a);
        System.out.println("Equal: " + a.equals(b));
        System.out.println("Same hash: " + (a.hashCode() == b.hashCode()));
    }
}

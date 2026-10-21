public class Task01Demo {
    static class Vehicle {
        String regNo;
        String type;
        Vehicle(String regNo, String type) { this.regNo = regNo; this.type = type; }
    }
    public static void main(String[] args) {
        Vehicle v = new Vehicle("TN01AB1111", "Car");
        System.out.println("Registration: " + v.regNo);
        System.out.println("Type: " + v.type);
    }
}

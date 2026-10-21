public class Task02Demo {
    public static void main(String[] args) {
        int[] slotsPerFloor = {2, 1, 3};
        String[][] slots = new String[slotsPerFloor.length][];
        for (int f = 0; f < slotsPerFloor.length; f++) slots[f] = new String[slotsPerFloor[f]];
        System.out.println("Floors: " + slots.length);
        System.out.println("Floor 0 slots: " + slots[0].length);
        System.out.println("Floor 1 slots: " + slots[1].length);
        System.out.println("Floor 2 slots: " + slots[2].length);
        int minutes = 61;
        int hours = (minutes + 59) / 60;
        System.out.println("Billable hours for 61 minutes: " + hours);
    }
}

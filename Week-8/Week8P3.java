import java.util.*;

public class Week8P3 {

    interface Room {
        double bill(int units, int occupants);
    }

    static class Single implements Room {
        public double bill(int units, int occupants) {
            return units * 8;
        }
    }

    static class Shared implements Room {
        public double bill(int units, int occupants) {
            return units * 6.0 / occupants;
        }
    }

    static class AC implements Room {
        public double bill(int units, int occupants) {
            return units * 10 + 200;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Room> rooms = new HashMap<>();

        rooms.put("SINGLE", new Single());
        rooms.put("SHARED", new Shared());
        rooms.put("AC", new AC());

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int units = sc.nextInt();

            int occupants = 1;

            if (type.equals("SHARED")) {
                occupants = sc.nextInt();
            }

            double bill = rooms.get(type).bill(units, occupants);

            System.out.printf("%s: %.2f%n", type, bill);

            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
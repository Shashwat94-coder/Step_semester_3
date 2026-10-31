import java.util.*;
import java.util.function.Function;

public class Week8P2 {

    interface Vehicle {
        double charge(int hours);
    }

    static class Bike implements Vehicle {
        public double charge(int hours) {
            return hours * 10;
        }
    }

    static class Car implements Vehicle {
        public double charge(int hours) {
            return 30 + (hours - 1) * 20;
        }
    }

    static class Truck implements Vehicle {
        public double charge(int hours) {
            return Math.max(100, hours * 50);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Vehicle> vehicles = new HashMap<>();

        vehicles.put("BIKE", new Bike());
        vehicles.put("CAR", new Car());
        vehicles.put("TRUCK", new Truck());

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int hours = sc.nextInt();

            double charge = vehicles.get(type).charge(hours);

            System.out.printf("%s: %.2f%n", type, charge);

            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
import java.util.*;
import java.util.function.Function;

public class Week8P1 {

    interface Customer {
        double finalAmount(double bill);
    }

    static class Student implements Customer {
        public double finalAmount(double bill) {
            return bill * 0.90;
        }
    }

    static class Staff implements Customer {
        public double finalAmount(double bill) {
            return bill * 0.95;
        }
    }

    static class Guest implements Customer {
        public double finalAmount(double bill) {
            return bill + 10;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Function<Double, Customer>> factory = new HashMap<>();

        factory.put("STUDENT", x -> new Student());
        factory.put("STAFF", x -> new Staff());
        factory.put("GUEST", x -> new Guest());

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double bill = sc.nextDouble();

            Customer customer = factory.get(type).apply(bill);

            double amount = customer.finalAmount(bill);

            System.out.printf("%s: %.2f%n", type, amount);

            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}

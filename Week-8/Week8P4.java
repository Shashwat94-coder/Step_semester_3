import java.util.*;

public class Week8P4 {

    interface Employee {
        double bonus(double salary);
    }

    static class FullTime implements Employee {
        public double bonus(double salary) {
            return salary * 0.10;
        }
    }

    static class PartTime implements Employee {
        public double bonus(double salary) {
            return salary * 0.05;
        }
    }

    static class Intern implements Employee {
        public double bonus(double salary) {
            return 2000;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Employee> employees = new HashMap<>();

        employees.put("FULLTIME", new FullTime());
        employees.put("PARTTIME", new PartTime());
        employees.put("INTERN", new Intern());

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            double bonus = employees.get(type).bonus(salary);

            System.out.printf("%s: %.2f%n", name, bonus);

            total += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
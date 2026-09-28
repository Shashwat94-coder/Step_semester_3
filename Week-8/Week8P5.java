import java.time.LocalDate;
import java.util.*;

public class Week8P5 {

    interface Plan {
        LocalDate renewalDate(LocalDate startDate);
    }

    static class Basic implements Plan {
        public LocalDate renewalDate(LocalDate startDate) {
            return startDate.plusDays(30);
        }
    }

    static class Standard implements Plan {
        public LocalDate renewalDate(LocalDate startDate) {
            return startDate.plusDays(90);
        }
    }

    static class Premium implements Plan {
        public LocalDate renewalDate(LocalDate startDate) {
            return startDate.plusDays(365);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Plan> plans = new HashMap<>();

        plans.put("BASIC", new Basic());
        plans.put("STANDARD", new Standard());
        plans.put("PREMIUM", new Premium());

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            LocalDate renewal =
                    plans.get(type).renewalDate(startDate);

            System.out.println(name + ": " + renewal);
        }
    }
}
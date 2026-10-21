
import java.util.Scanner;

public class CityCabFareMeter {

    interface NightService {
        default double applyNightCharge(double fare) {
            return fare * 1.20;
        }
    }

    static abstract class Cab {
        abstract double getRate();

        double calculateFare(double km) {
            return Math.max(100, km * getRate());
        }
    }

    static class Mini extends Cab {
        @Override
        double getRate() {
            return 10;
        }
    }

    static class Sedan extends Cab implements NightService {
        @Override
        double getRate() {
            return 14;
        }
    }

    static class SUV extends Cab implements NightService {
        @Override
        double getRate() {
            return 18;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new Mini();
                    break;
                case "SEDAN":
                    cab = new Sedan();
                    break;
                case "SUV":
                    cab = new SUV();
                    break;
                default:
                    throw new IllegalArgumentException(
                            "Invalid cab type: " + type);
            }

            if (time.equals("NIGHT")
                    && !(cab instanceof NightService)) {
                System.out.println(
                        type + ": night service not available");
                continue;
            }

            double fare = cab.calculateFare(km);

            if (time.equals("NIGHT")) {
                fare = ((NightService) cab)
                        .applyNightCharge(fare);
            }

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

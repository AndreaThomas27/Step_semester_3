
import java.util.Scanner;

public class TransportFareCalculator {

    static abstract class Transport {
        protected double distance;

        Transport(double distance) {
            this.distance = distance;
        }

        abstract double calculateFare();
    }

    static class Bus extends Transport {
        Bus(double distance) {
            super(distance);
        }

        @Override
        double calculateFare() {
            return Math.min(10, 2 + 0.10 * distance);
        }
    }

    static class Train extends Transport {
        Train(double distance) {
            super(distance);
        }

        @Override
        double calculateFare() {
            return 3 + 0.15 * distance;
        }
    }

    static class Metro extends Transport {
        private double peakHourFactor;

        Metro(double distance, double peakHourFactor) {
            super(distance);
            this.peakHourFactor = peakHourFactor;
        }

        @Override
        double calculateFare() {
            return (1.50 + 0.20 * distance) * peakHourFactor;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            Transport transport;

            switch (type) {
                case "BUS":
                    transport = new Bus(distance);
                    break;
                case "TRAIN":
                    transport = new Train(distance);
                    break;
                case "METRO":
                    double factor = sc.nextDouble();
                    transport = new Metro(distance, factor);
                    break;
                default:
                    throw new IllegalArgumentException(
                        "Invalid transport type: " + type);
            }

            double fare = transport.calculateFare();

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

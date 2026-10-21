
import java.util.Scanner;

public class HomeApplianceEnergyReport {

    interface SaverMode {
        default double applySaverMode(double units) {
            return units * 0.75;
        }
    }

    static abstract class Appliance {
        abstract double getPowerWatts();

        double calculateUnits(double hours) {
            return getPowerWatts() * hours / 1000.0;
        }

        double calculateCost(double units) {
            return units * 8;
        }
    }

    static class Fridge extends Appliance {
        @Override
        double getPowerWatts() {
            return 150;
        }
    }

    static class AirConditioner extends Appliance
            implements SaverMode {

        @Override
        double getPowerWatts() {
            return 1500;
        }
    }

    static class Television extends Appliance {
        @Override
        double getPowerWatts() {
            return 100;
        }
    }

    static class Washer extends Appliance
            implements SaverMode {

        @Override
        double getPowerWatts() {
            return 500;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");

            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);

            boolean saverRequested =
                    parts.length > 2
                    && parts[2].equals("SAVER");

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge();
                    break;
                case "AC":
                    appliance = new AirConditioner();
                    break;
                case "TV":
                    appliance = new Television();
                    break;
                case "WASHER":
                    appliance = new Washer();
                    break;
                default:
                    throw new IllegalArgumentException(
                            "Invalid appliance type: " + type);
            }

            if (saverRequested
                    && !(appliance instanceof SaverMode)) {
                System.out.println(
                        type + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits(hours);

            if (saverRequested) {
                units = ((SaverMode) appliance)
                        .applySaverMode(units);
            }

            double cost = appliance.calculateCost(units);

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost);

            totalCost += cost;
        }

        System.out.printf(
                "Total Cost: %.2f%n", totalCost);

        sc.close();
    }
}

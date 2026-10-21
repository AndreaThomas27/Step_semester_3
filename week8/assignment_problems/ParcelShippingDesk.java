
import java.util.Scanner;

public class ParcelShippingDesk {

    interface Insurable {
        double calculateInsurance();
    }

    static abstract class Parcel {
        protected double weight;
        protected double declaredValue;

        Parcel(double weight, double declaredValue) {
            this.weight = weight;
            this.declaredValue = declaredValue;
        }

        abstract double calculateCharge();
    }

    static class StandardParcel extends Parcel {
        StandardParcel(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        @Override
        double calculateCharge() {
            return 40 + 10 * weight;
        }
    }

    static class ExpressParcel extends Parcel
            implements Insurable {

        ExpressParcel(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        @Override
        double calculateCharge() {
            return 80 + 15 * weight;
        }

        @Override
        public double calculateInsurance() {
            return declaredValue * 0.02;
        }
    }

    static class FragileParcel extends StandardParcel
            implements Insurable {

        FragileParcel(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        @Override
        double calculateCharge() {
            return super.calculateCharge() + 50;
        }

        @Override
        public double calculateInsurance() {
            return declaredValue * 0.02;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            Parcel parcel;

            switch (type) {
                case "STANDARD":
                    parcel = new StandardParcel(
                            weight, declaredValue);
                    break;
                case "EXPRESS":
                    parcel = new ExpressParcel(
                            weight, declaredValue);
                    break;
                case "FRAGILE":
                    parcel = new FragileParcel(
                            weight, declaredValue);
                    break;
                default:
                    throw new IllegalArgumentException(
                            "Invalid parcel type: " + type);
            }

            double charge = parcel.calculateCharge();
            double insurance = 0;

            if (parcel instanceof Insurable) {
                insurance =
                        ((Insurable) parcel).calculateInsurance();
            }

            double total = charge + insurance;

            System.out.printf(
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    type, charge, insurance, total);

            grandTotal += total;
        }

        System.out.printf(
                "Grand Total: %.2f%n", grandTotal);

        sc.close();
    }
}



import java.util.Scanner;

public class CollegeFeeCounter {

    interface BusUser {
        double TRANSPORT_FEE = 12000;

        default double getTransportFee() {
            return TRANSPORT_FEE;
        }
    }

    static abstract class Student {
        protected String name;

        Student(String name) {
            this.name = name;
        }

        abstract double getTuition();

        double getExtraFee() {
            return 0;
        }

        double calculateTotalFee() {
            return getTuition() + getExtraFee();
        }
    }

    static class DayScholar extends Student
            implements BusUser {

        DayScholar(String name) {
            super(name);
        }

        @Override
        double getTuition() {
            return 40000;
        }

        @Override
        double getExtraFee() {
            return getTransportFee();
        }
    }

    static class Hosteller extends Student {
        Hosteller(String name) {
            super(name);
        }

        @Override
        double getTuition() {
            return 40000;
        }

        @Override
        double getExtraFee() {
            return 60000;
        }
    }

    static class ScholarshipStudent extends Student
            implements BusUser {

        ScholarshipStudent(String name) {
            super(name);
        }

        @Override
        double getTuition() {
            return 20000;
        }

        @Override
        double getExtraFee() {
            return getTransportFee();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new ScholarshipStudent(name);
                    break;
                default:
                    throw new IllegalArgumentException(
                            "Invalid student type: " + type);
            }

            double fee = student.calculateTotalFee();

            System.out.printf(
                    "%s: %.2f%n", student.name, fee);

            totalCollected += fee;
        }

        System.out.printf(
                "Total Collected: %.2f%n", totalCollected);

        sc.close();
    }
}

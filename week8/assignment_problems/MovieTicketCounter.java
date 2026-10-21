
import java.util.Scanner;

public class MovieTicketCounter {

    static abstract class Ticket {
        private static final double CONVENIENCE_FEE = 20;
        protected int count;

        Ticket(int count) {
            this.count = count;
        }

        abstract double getPrice();

        double calculateAmount() {
            return count * (getPrice() + CONVENIENCE_FEE);
        }
    }

    static class RegularTicket extends Ticket {
        RegularTicket(int count) {
            super(count);
        }

        @Override
        double getPrice() {
            return 150;
        }
    }

    static class PremiumTicket extends Ticket {
        PremiumTicket(int count) {
            super(count);
        }

        @Override
        double getPrice() {
            return 250;
        }
    }

    static class ReclinerTicket extends Ticket {
        ReclinerTicket(int count) {
            super(count);
        }

        @Override
        double getPrice() {
            return 400;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();

            Ticket ticket;

            switch (seat) {
                case "REGULAR":
                    ticket = new RegularTicket(count);
                    break;
                case "PREMIUM":
                    ticket = new PremiumTicket(count);
                    break;
                case "RECLINER":
                    ticket = new ReclinerTicket(count);
                    break;
                default:
                    throw new IllegalArgumentException(
                            "Invalid seat type: " + seat);
            }

            double amount = ticket.calculateAmount();

            System.out.printf("%s: %.2f%n", seat, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}


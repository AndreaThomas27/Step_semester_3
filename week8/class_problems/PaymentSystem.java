
import java.util.Scanner;

public class PaymentSystem {

    static abstract class Payment {
        abstract double calculateAmount(double amount);
    }

    static class CardPayment extends Payment {
        @Override
        double calculateAmount(double amount) {
            return amount * 1.02;
        }
    }

    static class WalletPayment extends Payment {
        @Override
        double calculateAmount(double amount) {
            return amount * 1.01;
        }
    }

    static class BankTransferPayment extends Payment {
        @Override
        double calculateAmount(double amount) {
            return amount;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Payment payment;

            switch (type) {
                case "CARD":
                    payment = new CardPayment();
                    break;
                case "WALLET":
                    payment = new WalletPayment();
                    break;
                case "BANKTRANSFER":
                    payment = new BankTransferPayment();
                    break;
                default:
                    throw new IllegalArgumentException(
                        "Invalid payment type: " + type);
            }

            double adjusted = payment.calculateAmount(amount);

            System.out.printf("%s: %.2f%n", type, adjusted);
            total += adjusted;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

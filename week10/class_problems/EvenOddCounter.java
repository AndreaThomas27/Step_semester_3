
import java.util.Scanner;

public class EvenOddCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine().trim();
        input = input.replace("[", "").replace("]", "");

        String[] numbers = input.split(",");
        int even = 0;
        int odd = 0;

        for (String number : numbers) {
            int value = Integer.parseInt(number.trim());

            if (value % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);

        sc.close();
    }
}

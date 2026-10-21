
import java.util.Scanner;
import java.time.LocalDate;

public class LibraryDueDate {

    static abstract class LibraryItem {
        protected String title;

        LibraryItem(String title) {
            this.title = title;
        }

        abstract int getBorrowDays();

        LocalDate getDueDate(LocalDate currentDate) {
            return currentDate.plusDays(getBorrowDays());
        }
    }

    static class Book extends LibraryItem {
        Book(String title) {
            super(title);
        }

        @Override
        int getBorrowDays() {
            return 14;
        }
    }

    static class DVD extends LibraryItem {
        DVD(String title) {
            super(title);
        }

        @Override
        int getBorrowDays() {
            return 7;
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title) {
            super(title);
        }

        @Override
        int getBorrowDays() {
            return 3;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();

            int spaceIndex = line.indexOf(' ');
            String type = line.substring(0, spaceIndex);
            String title = line.substring(spaceIndex + 1).trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new Book(title);
                    break;
                case "DVD":
                    item = new DVD(title);
                    break;
                case "MAGAZINE":
                    item = new Magazine(title);
                    break;
                default:
                    throw new IllegalArgumentException(
                        "Invalid item type: " + type);
            }

            System.out.println(
                item.title + ": " + item.getDueDate(currentDate));
        }

        sc.close();
    }
}

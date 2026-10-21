
import java.util.Scanner;
import java.util.Locale;

public class StudentResultCard {

    static class Student {
        private String name;
        private int[] marks;

        Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks.clone();
        }

        double calculateAverage() {
            int total = 0;

            for (int mark : marks) {
                total += mark;
            }

            return total / 3.0;
        }

        char getGrade() {
            double average = calculateAverage();

            if (average >= 90) {
                return 'A';
            } else if (average >= 75) {
                return 'B';
            } else if (average >= 60) {
                return 'C';
            } else if (average >= 40) {
                return 'D';
            } else {
                return 'F';
            }
        }

        void displayResult() {
            System.out.printf(
                Locale.US,
                "%s: Average %.1f, Grade %c%n",
                name.toUpperCase(Locale.ROOT),
                calculateAverage(),
                getGrade()
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            // Input format: Asha [80, 90, 70]
            int bracketIndex = line.indexOf('[');

            String name = line.substring(0, bracketIndex).trim();

            String marksText = line.substring(bracketIndex)
                    .replace("[", "")
                    .replace("]", "");

            String[] parts = marksText.split(",");
            int[] marks = new int[3];

            for (int i = 0; i < 3; i++) {
                marks[i] = Integer.parseInt(parts[i].trim());
            }

            Student student = new Student(name, marks);
            student.displayResult();
        }

        sc.close();
    }
}


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExaminationGrader {

    static abstract class Question {
        protected String correctAnswer;
        protected String studentAnswer;
        protected int points;

        Question(String correctAnswer, String studentAnswer, int points) {
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        abstract double grade();
    }

    static class MCQ extends Question {
        MCQ(String correct, String student, int points) {
            super(correct, student, points);
        }

        @Override
        double grade() {
            return correctAnswer.equals(studentAnswer) ? points : 0;
        }
    }

    static class TrueFalse extends Question {
        TrueFalse(String correct, String student, int points) {
            super(correct, student, points);
        }

        @Override
        double grade() {
            return correctAnswer.equals(studentAnswer) ? points : 0;
        }
    }

    static class Essay extends Question {
        Essay(String correct, String student, int points) {
            super(correct, student, points);
        }

        @Override
        double grade() {
            String[] keywords = correctAnswer.split(",");
            String answer = studentAnswer.toLowerCase();

            int matches = 0;

            for (String keyword : keywords) {
                if (answer.contains(keyword.trim().toLowerCase())) {
                    matches++;
                }
            }

            if (matches >= 2) {
                return points * 0.75;
            } else if (matches == 1) {
                return points * 0.50;
            }

            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        Pattern pattern = Pattern.compile(
            "^(MCQ|TF|ESSAY)\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+(\\d+)\\s*$"
        );

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            Matcher matcher = pattern.matcher(line);

            if (!matcher.matches()) {
                throw new IllegalArgumentException(
                    "Invalid question input: " + line);
            }

            String type = matcher.group(1);
            String correct = matcher.group(3);
            String student = matcher.group(4);
            int points = Integer.parseInt(matcher.group(5));

            Question question;

            switch (type) {
                case "MCQ":
                    question = new MCQ(correct, student, points);
                    break;
                case "TF":
                    question = new TrueFalse(correct, student, points);
                    break;
                case "ESSAY":
                    question = new Essay(correct, student, points);
                    break;
                default:
                    throw new IllegalArgumentException(
                        "Invalid question type: " + type);
            }

            double score = question.grade();

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}


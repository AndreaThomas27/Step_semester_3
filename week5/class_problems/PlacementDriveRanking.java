
import java.util.Arrays;

public class PlacementDriveRanking {

    static String shortlistAndRank(Candidate[] candidates) {
        int count = 0;

        for (Candidate candidate : candidates) {
            if (Candidate.isEligible(candidate.getCgpa())
                    || Candidate.isEligible(
                        candidate.getCgpa(),
                        candidate.getCodingScore())) {
                count++;
            }
        }

        Candidate[] shortlisted = new Candidate[count];
        int index = 0;

        for (Candidate candidate : candidates) {
            if (Candidate.isEligible(candidate.getCgpa())
                    || Candidate.isEligible(
                        candidate.getCgpa(),
                        candidate.getCodingScore())) {
                shortlisted[index++] = candidate;
            }
        }

        Arrays.sort(shortlisted);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < shortlisted.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }

            result.append(i + 1).append(". ")
                  .append(shortlisted[i].getName())
                  .append(" (")
                  .append(String.format(
                      java.util.Locale.US,
                      "%.1f",
                      shortlisted[i].getCompositeScore()))
                  .append(")");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}

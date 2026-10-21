
import java.util.Arrays;

public class FantasyLeagueAutoDraft {

    static String draftAndRank(Player[] players) {

        int count = 0;

        for (Player player : players) {

            if (Player.isDraftable(player.getMatchesPlayed())
                    || Player.isDraftable(
                        player.getMatchesPlayed(),
                        player.isInjured())) {
                count++;
            }
        }

        Player[] draftable = new Player[count];

        int index = 0;

        for (Player player : players) {

            if (Player.isDraftable(player.getMatchesPlayed())
                    || Player.isDraftable(
                        player.getMatchesPlayed(),
                        player.isInjured())) {

                draftable[index] = player;
                index++;
            }
        }

        Arrays.sort(draftable);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < draftable.length; i++) {

            if (i > 0) {
                result.append(" | ");
            }

            result.append(i + 1)
                  .append(". ")
                  .append(draftable[i].getName());
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}

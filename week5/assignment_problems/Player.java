
public class Player implements Comparable<Player> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed,
                  double battingAverage, boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed,
                               boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    public String getName() {
        return name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public boolean isInjured() {
        return injured;
    }

    public double getFantasyPoints() {
        return battingAverage + (matchesPlayed * 2);
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(
            other.getFantasyPoints(),
            this.getFantasyPoints()
        );
    }
}

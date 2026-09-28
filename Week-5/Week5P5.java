import java.util.Arrays;

public class Week5P5 implements Comparable<Week5P5> {

    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;

    public Week5P5(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(Week5P5 other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    static String draftAndRank(Week5P5[] players) {

        Week5P5[] draftable = new Week5P5[players.length];
        int count = 0;

        for (Week5P5 player : players) {

            if (isDraftable(player.matchesPlayed) ||
                isDraftable(player.matchesPlayed, player.injured)) {

                draftable[count] = player;
                count++;
            }
        }

        Week5P5[] result = Arrays.copyOf(draftable, count);

        Arrays.sort(result);

        String output = "";

        for (int i = 0; i < result.length; i++) {
            output += (i + 1) + ". " + result[i].name;

            if (i < result.length - 1) {
                output += " | ";
            }
        }

        return output;
    }

    public static void main(String[] args) {

        Week5P5[] players = {
            new Week5P5("Virat", 15, 48.0, false),
            new Week5P5("Rahul", 7, 55.0, false),
            new Week5P5("Sameer", 3, 60.0, false),
            new Week5P5("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}
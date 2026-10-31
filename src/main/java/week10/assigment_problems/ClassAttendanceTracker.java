class ClassAttendanceTracker {
    public static void main(String[] args) {
        int[] days = {1, 1, 0, 1, 1, 1, 0, 1};

        int present = 0;
        int streak = 0;
        int longest = 0;

        for (int day : days) {
            if (day == 1) {
                present++;
                streak++;

                if (streak > longest) {
                    longest = streak;
                }
            } else {
                streak = 0;
            }
        }

        System.out.println("Present: " + present
                + ", Longest streak: " + longest);
    }
}
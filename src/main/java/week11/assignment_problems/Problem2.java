import java.util.Arrays;

class Problem2 {
    static int prizeTable(int[] marks) {
        int swaps = 0;
        int n = marks.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIndex]) {
                    maxIndex = j;
                }
            }

            if (maxIndex != i) {
                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;
                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        int[] marks = {45, 90, 60, 75};
        int swaps = prizeTable(marks);

        System.out.println(Arrays.toString(marks));
        System.out.println("Swaps = " + swaps);

        int[] marks2 = {80, 70, 60};
        int swaps2 = prizeTable(marks2);

        System.out.println(Arrays.toString(marks2));
        System.out.println("Swaps = " + swaps2);
    }
}
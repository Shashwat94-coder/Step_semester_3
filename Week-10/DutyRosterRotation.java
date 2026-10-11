import java.util.Arrays;

class DutyRosterRotation {
    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        int k = 7;

        int n = names.length;
        k = k % n;

        String[] rotated = new String[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = names[i];
        }

        System.out.println(Arrays.toString(rotated));
    }
}
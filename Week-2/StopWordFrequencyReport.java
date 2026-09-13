import java.util.*;

public class StopWordFrequencyReport {

    public static boolean isStopWord(String word, String[] stopWords) {

        for (String stopWord : stopWords) {

            if (word.equals(stopWord)) {
                return true;
            }
        }

        return false;
    }

    public static void printFilteredWordFrequency(String feedback) {

        String[] stopWords = {
            "the", "was", "and", "a", "is", "of", "in"
        };

        // Normalize text
        String cleaned = feedback.toLowerCase()
                                 .replace(".", "")
                                 .replace(",", "");

        String[] words = cleaned.split("\\s+");

        HashMap<String, Integer> frequency = new HashMap<>();

        // Count words
        for (String word : words) {

            if (!isStopWord(word, stopWords) && !word.isEmpty()) {

                frequency.put(
                    word,
                    frequency.getOrDefault(word, 0) + 1
                );
            }
        }

        // Convert map entries to list for sorting
        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());

        // Sort by frequency descending
        entries.sort(
            (a, b) -> Integer.compare(b.getValue(), a.getValue())
        );

        // Print result
        for (Map.Entry<String, Integer> entry : entries) {

            System.out.println(
                entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter feedback: ");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);

        sc.close();
    }
}
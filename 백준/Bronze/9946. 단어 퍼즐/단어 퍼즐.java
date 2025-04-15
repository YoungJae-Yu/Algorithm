import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = 1;

        while (true) {
            String original = sc.nextLine();
            String collected = sc.nextLine();

            if (original.equals("END") && collected.equals("END")) {
                break;
            }

            Map<Character, Integer> freqOriginal = getFrequencyMap(original);
            Map<Character, Integer> freqCollected = getFrequencyMap(collected);

            String result = freqOriginal.equals(freqCollected) ? "same" : "different";
            System.out.println("Case " + caseNum + ": " + result);
            caseNum++;
        }
    }

    private static Map<Character, Integer> getFrequencyMap(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        return freqMap;
    }
}
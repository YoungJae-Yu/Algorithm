import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        
        Map<String, Integer> wordCount = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M) continue;
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        List<String> words = new ArrayList<>(wordCount.keySet());
        
        Collections.sort(words, new Comparator<String>() {
            public int compare(String o1, String o2) {
                int freq1 = wordCount.get(o1);
                int freq2 = wordCount.get(o2);
                if (freq1 != freq2) {
                    return freq2 - freq1; // 빈도수 내림차순
                }
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length(); // 길이 내림차순
                }
                return o1.compareTo(o2); // 사전순 오름차순
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append('\n');
        }
        
        System.out.print(sb);
    }
}
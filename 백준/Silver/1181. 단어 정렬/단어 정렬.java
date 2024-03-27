import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 단어의 개수 N
        Set<String> wordSet = new HashSet<>(); // 중복을 제거하기 위한 Set

        for (int i = 0; i < N; i++) {
            wordSet.add(br.readLine()); // 단어를 Set에 추가하여 중복 제거
        }

        // Set을 List로 변환
        List<String> words = new ArrayList<>(wordSet);

        // 단어들을 길이가 짧은 순으로, 길이가 같다면 사전 순으로 정렬
        Collections.sort(words, (word1, word2) -> {
            if (word1.length() == word2.length()) {
                return word1.compareTo(word2); // 길이가 같으면 사전 순으로 정렬
            } else {
                return Integer.compare(word1.length(), word2.length()); // 길이로 정렬
            }
        });

        // 정렬된 단어 출력
        words.forEach(System.out::println);
    }
}

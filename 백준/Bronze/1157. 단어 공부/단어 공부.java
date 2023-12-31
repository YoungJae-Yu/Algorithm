import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toUpperCase(); // 입력 받은 문자열을 대문자로 통일

        int[] alphabetCount = new int[26]; // 알파벳 개수를 저장할 배열

        // 각 알파벳 등장 횟수 계산
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isAlphabetic(ch)) { // 알파벳인 경우에만 카운트
                alphabetCount[ch - 'A']++;
            }
        }

        char maxChar = '?';
        int maxCount = 0;
        boolean isDuplicated = false; // 여러 개의 최대 등장 알파벳인지 체크

        for (int i = 0; i < 26; i++) {
            if (alphabetCount[i] > maxCount) {
                maxChar = (char) ('A' + i);
                maxCount = alphabetCount[i];
                isDuplicated = false;
            } else if (alphabetCount[i] == maxCount) {
                isDuplicated = true;
            }
        }

        // 여러 개의 최대 등장 알파벳인 경우 '?' 출력, 아니면 해당 알파벳 대문자 출력
        System.out.println(isDuplicated ? "?" : maxChar);
    }
}

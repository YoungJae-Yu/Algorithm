import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim(); // 문자열 입력

        // 공백을 기준으로 문자열을 나눠서 배열로 저장
        String[] words = input.split(" ");

        int count = 0;
        for (String word : words) {
            // 공백이 아닌 문자열인 경우에만 count 증가
            if (!word.equals("")) {
                count++;
            }
        }

        System.out.println(count);
    }
}

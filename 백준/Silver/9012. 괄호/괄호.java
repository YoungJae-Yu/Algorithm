import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            System.out.println(isValidPS(br.readLine()) ? "YES" : "NO");
        }
    }

    public static boolean isValidPS(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            // 닫힌 괄호가 열린 괄호보다 많아지는 순간 올바른 괄호 문자열이 아님
            if (count < 0) {
                return false;
            }
        }

        // 모든 검사가 끝난 후 열린 괄호와 닫힌 괄호의 수가 정확히 일치해야 함
        return count == 0;
    }
}

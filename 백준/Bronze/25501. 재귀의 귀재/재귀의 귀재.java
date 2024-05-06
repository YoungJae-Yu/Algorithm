import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count; // recursion 함수 호출 횟수를 세기 위한 전역 변수

    public static int recursion(String s, int l, int r) {
        count++; // recursion 함수가 호출될 때마다 count를 1 증가
        if (l >= r) return 1; // 기저 조건: 문자열의 길이가 1 이하이거나 모든 문자가 검사되었을 때
        else if (s.charAt(l) != s.charAt(r)) return 0; // 팰린드롬이 아니면 0 반환
        else return recursion(s, l + 1, r - 1); // 다음 문자를 검사하기 위해 재귀 호출
    }

    public static int isPalindrome(String s) {
        count = 0; // 각 테스트 케이스마다 count 초기화
        return recursion(s, 0, s.length() - 1); // recursion 함수 호출
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수 입력

        for (int i = 0; i < T; i++) {
            String s = br.readLine(); // 문자열 입력
            int result = isPalindrome(s); // 팰린드롬 여부 확인
            System.out.println(result + " " + count); // 팰린드롬 여부와 recursion 함수의 호출 횟수 출력
        }
    }
}

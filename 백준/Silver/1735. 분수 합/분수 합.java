import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 분수 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A1 = Integer.parseInt(st.nextToken());
        int B1 = Integer.parseInt(st.nextToken());

        // 두 번째 분수 입력
        st = new StringTokenizer(br.readLine(), " ");
        int A2 = Integer.parseInt(st.nextToken());
        int B2 = Integer.parseInt(st.nextToken());

        // 분수의 합 계산
        int numerator = A1 * B2 + A2 * B1; // 분자
        int denominator = B1 * B2; // 분모

        // 최대공약수로 나누어 기약분수 만들기
        int gcd = gcd(numerator, denominator);

        System.out.println((numerator / gcd) + " " + (denominator / gcd));
    }

    // 최대공약수 구하는 메소드
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
   
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break; // 0이 입력되면 프로그램 종료
            
            int count = 0; // n과 2n 사이의 소수의 개수를 저장할 변수
            boolean[] isPrime = new boolean[2 * n + 1]; // 소수 판별 배열
            for (int i = 2; i <= 2 * n; i++) isPrime[i] = true; // 초기값 true로 설정
            
            // 에라토스테네스의 체 알고리즘
            for (int i = 2; i * i <= 2 * n; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j <= 2 * n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
            
            // n보다 크고 2n보다 작거나 같은 소수의 개수 세기
            for (int i = n + 1; i <= 2 * n; i++) {
                if (isPrime[i]) count++;
            }
            
            System.out.println(count);
        }
    }
}

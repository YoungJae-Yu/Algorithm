import java.io.*;

public class Main {
    // 전역 변수로 코드1과 코드2의 실행 횟수를 카운트할 변수 선언
    static int countCode1 = 0;
    static int countCode2 = 0;

    // 피보나치 수를 재귀호출로 계산하는 메소드
    public static int fib(int n) {
        if (n == 1 || n == 2) {
            countCode1++; // 코드1 실행 횟수 카운트
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    // 피보나치 수를 동적 프로그래밍으로 계산하는 메소드
    public static int fibonacci(int n) {
        int[] f = new int[n + 1];
        f[1] = f[2] = 1;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            countCode2++; // 코드2 실행 횟수 카운트
        }
        return f[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        fib(n); // 재귀호출로 피보나치 수 계산
        fibonacci(n); // 동적 프로그래밍으로 피보나치 수 계산

        // 코드1과 코드2의 실행 횟수 출력
        System.out.println(countCode1 + " " + countCode2);
    }
}

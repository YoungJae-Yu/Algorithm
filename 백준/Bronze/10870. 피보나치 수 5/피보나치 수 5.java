import java.util.Scanner;

public class Main {
    // 피보나치 수를 계산하는 재귀 함수
    public static int fibonacci(int n) {
        // 기본 조건: 0번째 피보나치 수는 0, 1번째 피보나치 수는 1
        if (n <= 1) {
            return n;
        } else {
            // Fn = Fn-1 + Fn-2
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 n 입력 받기
        int n = scanner.nextInt();

        // 피보나치 수 계산 및 출력
        System.out.println(fibonacci(n));
    }
}

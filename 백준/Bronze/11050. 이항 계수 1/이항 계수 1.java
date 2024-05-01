import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        System.out.println(binomialCoefficient(N, K));
    }

    // 이항 계수를 계산하는 메서드
    public static int binomialCoefficient(int N, int K) {
        return factorial(N) / (factorial(K) * factorial(N - K));
    }

    // 팩토리얼을 계산하는 메서드
    public static int factorial(int n) {
        if (n <= 1) return 1;
        else return n * factorial(n - 1);
    }
}

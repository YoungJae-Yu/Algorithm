import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 테스트 케이스의 개수

        while (T-- > 0) {
            long n = scanner.nextLong();
            while (!isPrime(n)) {
                n++;
            }
            System.out.println(n);
        }

        scanner.close();
    }

    // 소수 판별 메서드
    public static boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

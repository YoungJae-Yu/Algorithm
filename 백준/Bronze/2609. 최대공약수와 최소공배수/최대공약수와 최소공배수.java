import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int gcd = calculateGCD(a, b);
        int lcm = calculateLCM(a, b, gcd);

        System.out.println(gcd);
        System.out.println(lcm);
        scanner.close();
    }

    // 최대 공약수 계산 (유클리드 호제법 사용)
    private static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 최소 공배수 계산
    private static int calculateLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
}

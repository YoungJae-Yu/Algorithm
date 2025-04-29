import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt(), Y = sc.nextInt(), P1 = sc.nextInt(), P2 = sc.nextInt();
        if (Math.abs(P2 - P1) % gcd(X, Y) != 0) {
            System.out.print(-1);
            return;
        }
        while (P1 != P2) {
            if (P1 < P2) P1 += X;
            else          P2 += Y;
        }
        System.out.print(P1);
    }
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
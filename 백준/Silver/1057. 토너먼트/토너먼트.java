import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int round = 1;
        while (true) {
            if (Math.abs(a - b) == 1 && (a % 2 == 0 && a - 1 == b || b % 2 == 0 && b - 1 == a)) {
                System.out.println(round);
                break;
            }

            a = (a + 1) / 2;
            b = (b + 1) / 2;
            round++;
        }
    }
}

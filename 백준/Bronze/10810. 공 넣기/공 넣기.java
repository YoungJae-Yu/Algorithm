import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] baskets = new int[N];

        for (int i = 0; i < M; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int ball = scanner.nextInt();

            for (int j = start - 1; j < end; j++) {
                baskets[j] = ball;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(baskets[i] + " ");
        }
    }
}

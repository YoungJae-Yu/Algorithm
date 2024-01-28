import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] baskets = new int[N];

        for (int i = 0; i < N; i++) {
            baskets[i] = i + 1;
        }

        for (int i = 0; i < M; i++) {
            int basket1 = scanner.nextInt() - 1;
            int basket2 = scanner.nextInt() - 1;

            int temp = baskets[basket1];
            baskets[basket1] = baskets[basket2];
            baskets[basket2] = temp;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(baskets[i] + " ");
        }
    }
}

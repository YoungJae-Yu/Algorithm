import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] scores = new int[N];
        int maxScore = 0;
        double sum = 0;

        for (int i = 0; i < N; i++) {
            scores[i] = scanner.nextInt();
            maxScore = Math.max(maxScore, scores[i]);
        }

        for (int i = 0; i < N; i++) {
            sum += (double) scores[i] / maxScore * 100;
        }

        System.out.println(sum / N);
    }
}

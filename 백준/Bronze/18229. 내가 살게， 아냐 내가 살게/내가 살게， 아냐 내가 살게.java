import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int[][] len = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                len[i][j] = sc.nextInt();
            }
        }
        int[] sum = new int[N];
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                sum[i] += len[i][j];
                if (sum[i] >= K) {
                    System.out.println((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }
    }
}
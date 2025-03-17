import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String message = sc.next();
        sc.close();

        int N = message.length();
        int R = 1, C = N;

        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                R = i;
                C = N / i;
            }
        }

        char[][] arr = new char[R][C];
        int index = 0;

        for (int c = 0; c < C; c++) {
            for (int r = 0; r < R; r++) {
                arr[r][c] = message.charAt(index++);
            }
        }

        StringBuilder decoded = new StringBuilder();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                decoded.append(arr[r][c]);
            }
        }

        System.out.println(decoded.toString());
    }
}
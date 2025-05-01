import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int x1 = -1, y1 = -1, x2 = -1, y2 = -1, count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (sc.nextInt() == 1) {
                    if (count == 0) {
                        x1 = i; y1 = j;
                    } else {
                        x2 = i; y2 = j;
                    }
                    count++;
                }
            }
        }
        System.out.print(Math.abs(x1 - x2) + Math.abs(y1 - y2));
    }
}
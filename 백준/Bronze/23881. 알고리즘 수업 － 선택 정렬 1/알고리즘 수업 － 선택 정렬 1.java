import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = N - 1; i > 0; i--) {
            int maxIdx = 0;
            for (int j = 1; j <= i; j++) {
                if (A[j] > A[maxIdx]) {
                    maxIdx = j;
                }
            }

            if (i != maxIdx) {
                int temp = A[i];
                A[i] = A[maxIdx];
                A[maxIdx] = temp;
                count++;
                if (count == K) {
                    System.out.println(A[maxIdx] + " " + A[i]);
                    return;
                }
            }
        }

        System.out.println(-1);
    }
}
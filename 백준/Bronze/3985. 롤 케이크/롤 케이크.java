import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int N = sc.nextInt();
        int[] cake = new int[L + 1];
        int maxExpected = 0;
        int maxExpectedPerson = 0;
        int maxActual = 0;
        int maxActualPerson = 0;

        for (int i = 1; i <= N; i++) {
            int p = sc.nextInt();
            int k = sc.nextInt();
            int expected = k - p + 1;
            if (expected > maxExpected) {
                maxExpected = expected;
                maxExpectedPerson = i;
            }
            int actual = 0;
            for (int j = p; j <= k; j++) {
                if (cake[j] == 0) {
                    cake[j] = i;
                    actual++;
                }
            }
            if (actual > maxActual) {
                maxActual = actual;
                maxActualPerson = i;
            }
        }

        System.out.println(maxExpectedPerson);
        System.out.println(maxActualPerson);
    }
}
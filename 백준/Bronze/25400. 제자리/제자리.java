import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int currentExpected = 1;
        int retainedCount = 0;
        for (int i = 0; i < N; i++) {
            int cardValue = sc.nextInt();
            if (cardValue == currentExpected) {
                retainedCount++;
                currentExpected++;
            }
        }
        System.out.println(N - retainedCount);
        sc.close();
    }
}


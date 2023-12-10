
import java.util.Scanner;

public class Main {
    public static int testCase, n;
    public static Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        testCase = sc.nextInt();

        while (testCase-- > 0) {
            n = sc.nextInt();

            dp[0][0] = 1;
            dp[0][1] = 0;
            dp[1][0] = 0;
            dp[1][1] = 1;

            fibo(n);
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }

    // integer배열은 null로 초기화 된다.
    // 이것을 이용해서 배열 0, 1에서 부터 시작하지않게 하였다. 
    public static Integer[] fibo(int n) {

        // dp[0][0] = 1;
        // dp[0][1] = 0;
        // dp[1][0] = 0;
        // dp[1][1] = 1;

        // 0,1은 미리 초기화 해두었기 때문에 실질적으로 2부터 시작된다. 
        if (dp[n][0] == null || dp[n][1] == null) {

            dp[n][0] = fibo(n - 1)[0] + fibo(n - 2)[0];
            dp[n][1] = fibo(n - 1)[1] + fibo(n - 2)[1];

        }

        return dp[n];
    }
}
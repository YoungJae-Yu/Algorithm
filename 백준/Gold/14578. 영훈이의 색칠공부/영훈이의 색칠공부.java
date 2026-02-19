import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        final long MOD = 1_000_000_007L;
        if (n == 1) {
            System.out.println(0);
            return;
        }
        long aPrev2 = 0;
        long aPrev1 = 1;
        long aN = (n == 2) ? 1 : 0;
        for (int i = 3; i <= n; i++) {
            aN = ((long)(i - 1) * ((aPrev1 + aPrev2) % MOD)) % MOD;
            aPrev2 = aPrev1;
            aPrev1 = aN;
        }
        long fact = 1;
        for (int i = 1; i <= n; i++) fact = fact * i % MOD;
        System.out.println(fact * aN % MOD);
    }
}
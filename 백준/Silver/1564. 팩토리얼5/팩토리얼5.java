import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        long s = 1L;
        long MOD = 1000000000000L;
        for (int i = 2; i <= n; i++) {
            s *= i;
            while (s % 10 == 0) s /= 10;
            if (s >= MOD) s %= MOD;
        }
        while (s % 10 == 0) s /= 10;
        long ans = s % 100000L;
        System.out.printf("%05d", ans);
    }
}
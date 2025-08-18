import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long H = Long.parseLong(st.nextToken());
        long X = Long.parseLong(st.nextToken());
        final long MOD = 1_000_000_007L;
        long ans = 0;
        long mul = X % MOD;
        for (long i = 0; i < H; i++) {
            long c = Long.parseLong(br.readLine().trim());
            ans = (ans + (c % MOD) * mul) % MOD;
            mul = (mul * X) % MOD;
        }
        System.out.println(ans % MOD);
    }
}
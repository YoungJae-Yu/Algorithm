import java.io.*;
import java.util.*;

public class Main {
    static long sum(long n) {
        if (n < 0) return 0;
        long res = 0;
        long p = 1;
        while (p <= n) {
            long higher = n / (p * 10);
            long cur = (n / p) % 10;
            long lower = n % p;
            res += higher * 45L * p;
            res += cur * (lower + 1);
            res += p * (cur * (cur - 1) / 2);
            p *= 10;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long L = Long.parseLong(st.nextToken());
        long U = Long.parseLong(st.nextToken());
        System.out.println(sum(U) - sum(L - 1));
    }
}
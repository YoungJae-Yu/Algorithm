import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long[] fib = new long[Math.max(3, N+1)];
        fib[1] = 1;
        fib[2] = 1;
        for (int i = 3; i <= N; i++) fib[i] = fib[i-1] + fib[i-2];
        long coeffA = fib[N-2];
        long coeffB = fib[N-1];
        for (long A = 1; A <= K; A++) {
            long rem = K - coeffA * A;
            if (rem <= 0) continue;
            if (rem % coeffB != 0) continue;
            long B = rem / coeffB;
            if (B >= A) {
                System.out.println(A);
                System.out.println(B);
                break;
            }
        }
    }
}
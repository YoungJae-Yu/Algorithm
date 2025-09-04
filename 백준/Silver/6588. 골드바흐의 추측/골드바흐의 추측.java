import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        final int MAX = 1000000;
        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            boolean found = false;
            for (int a = 2; a <= n; a++) {
                if (isPrime[a] && isPrime[n - a]) {
                    sb.append(n).append(" = ").append(a).append(" + ").append(n - a).append('\n');
                    found = true;
                    break;
                }
            }
            if (!found) {
                sb.append("Goldbach's conjecture is wrong.").append('\n');
            }
        }
        System.out.print(sb.toString());
    }
}
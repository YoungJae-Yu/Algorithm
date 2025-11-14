import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = B;
        int[] spf = new int[N+1];
        for (int i = 2; i <= N; i++) {
            if (spf[i] == 0) {
                for (int j = i; j <= N; j += i) {
                    if (spf[j] == 0) spf[j] = i;
                }
            }
        }
        int[] cnt = new int[N+1];
        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
        if (N >= 0) isPrime[0] = false;
        if (N >= 1) isPrime[1] = false;
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) isPrime[j] = false;
            }
        }
        for (int i = 2; i <= N; i++) {
            if (spf[i] == i) cnt[i] = 1;
            else cnt[i] = cnt[i / spf[i]] + 1;
        }
        int ans = 0;
        for (int i = A; i <= B; i++) {
            if (isPrime[cnt[i]]) ans++;
        }
        System.out.println(ans);
    }
}
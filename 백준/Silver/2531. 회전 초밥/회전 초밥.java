import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) sushi[i] = Integer.parseInt(br.readLine());
        int[] cnt = new int[D + 1];
        int unique = 0;
        for (int i = 0; i < K; i++) {
            if (cnt[sushi[i]]++ == 0) unique++;
        }
        int ans = unique + (cnt[C] == 0 ? 1 : 0);
        for (int s = 1; s < N; s++) {
            int out = sushi[s - 1];
            if (--cnt[out] == 0) unique--;
            int in = sushi[(s + K - 1) % N];
            if (cnt[in]++ == 0) unique++;
            int cur = unique + (cnt[C] == 0 ? 1 : 0);
            if (cur > ans) ans = cur;
        }
        System.out.println(ans);
    }
}
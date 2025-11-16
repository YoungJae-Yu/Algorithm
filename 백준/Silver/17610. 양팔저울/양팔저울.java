import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static int[] w;
    static boolean[] possible;
    static int sum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = new int[K];
        for (int i = 0; i < K; i++) w[i] = Integer.parseInt(st.nextToken());
        sum = 0;
        for (int x : w) sum += x;
        possible = new boolean[sum + 1];
        dfs(0, 0);
        int cnt = 0;
        for (int i = 1; i <= sum; i++) if (!possible[i]) cnt++;
        System.out.println(cnt);
    }
    static void dfs(int idx, int diff) {
        if (idx == K) {
            possible[Math.abs(diff)] = true;
            return;
        }
        dfs(idx + 1, diff);
        dfs(idx + 1, diff + w[idx]);
        dfs(idx + 1, Math.abs(diff - w[idx]));
    }
}
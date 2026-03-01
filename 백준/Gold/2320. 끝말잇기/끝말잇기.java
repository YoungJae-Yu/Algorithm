import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String[] words;
    static int[] len;
    static int[] first;
    static int[] last;
    static int[][] memo;

    static int charIdx(char c) {
        switch (c) {
            case 'A': return 0;
            case 'E': return 1;
            case 'I': return 2;
            case 'O': return 3;
            case 'U': return 4;
        }
        return -1;
    }

    static int dfs(int mask, int lastIdx) {
        int mi = mask;
        int li = lastIdx;
        if (memo[mi][li] != -1) return memo[mi][li];
        int best = 0;
        for (int j = 0; j < N; j++) {
            if ((mask & (1 << j)) != 0) continue;
            if (lastIdx == N || last[lastIdx] == first[j]) {
                int val = len[j] + dfs(mask | (1 << j), j);
                if (val > best) best = val;
            }
        }
        memo[mi][li] = best;
        return best;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        words = new String[N];
        len = new int[N];
        first = new int[N];
        last = new int[N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine().trim();
            words[i] = s;
            len[i] = s.length();
            first[i] = charIdx(s.charAt(0));
            last[i] = charIdx(s.charAt(s.length() - 1));
        }
        memo = new int[1 << N][N + 1];
        for (int i = 0; i < (1 << N); i++) Arrays.fill(memo[i], -1);
        int ans = dfs(0, N);
        System.out.println(ans);
    }
}
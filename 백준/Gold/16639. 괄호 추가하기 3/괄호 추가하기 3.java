import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine().trim();
        int M = (N + 1) / 2;
        long[] nums = new long[M];
        char[] ops = new char[M - 1];
        for (int i = 0; i < M; i++) nums[i] = s.charAt(2 * i) - '0';
        for (int i = 0; i < M - 1; i++) ops[i] = s.charAt(2 * i + 1);
        long[][] max = new long[M][M];
        long[][] min = new long[M][M];
        for (int i = 0; i < M; i++) {
            Arrays.fill(max[i], Long.MIN_VALUE / 4);
            Arrays.fill(min[i], Long.MAX_VALUE / 4);
        }
        for (int i = 0; i < M; i++) {
            max[i][i] = nums[i];
            min[i][i] = nums[i];
        }
        for (int len = 1; len < M; len++) {
            for (int i = 0; i + len < M; i++) {
                int j = i + len;
                for (int k = i; k < j; k++) {
                    char op = ops[k];
                    long a = max[i][k], b = min[i][k], c = max[k + 1][j], d = min[k + 1][j];
                    if (op == '+') {
                        max[i][j] = Math.max(max[i][j], a + c);
                        min[i][j] = Math.min(min[i][j], b + d);
                    } else if (op == '-') {
                        max[i][j] = Math.max(max[i][j], a - d);
                        min[i][j] = Math.min(min[i][j], b - c);
                    } else if (op == '*') {
                        long[] cand = new long[] {a * c, a * d, b * c, b * d};
                        long mx = cand[0], mn = cand[0];
                        for (int t = 1; t < 4; t++) {
                            if (cand[t] > mx) mx = cand[t];
                            if (cand[t] < mn) mn = cand[t];
                        }
                        if (mx > max[i][j]) max[i][j] = mx;
                        if (mn < min[i][j]) min[i][j] = mn;
                    }
                }
            }
        }
        System.out.println(max[0][M - 1]);
    }
}
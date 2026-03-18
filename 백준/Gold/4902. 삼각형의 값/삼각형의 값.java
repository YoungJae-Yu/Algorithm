import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 1;
        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("0")) break;
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            long[][] pre = new long[n + 1][2 * n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= 2 * i - 1; j++) {
                    int v = Integer.parseInt(st.nextToken());
                    pre[i][j] = pre[i][j - 1] + v;
                }
            }
            long max = Long.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= 2 * i - 1; j += 2) {
                    long sum = 0;
                    for (int k = 0; i + k <= n; k++) {
                        int row = i + k;
                        int left = j;
                        int right = j + 2 * k;
                        sum += pre[row][right] - pre[row][left - 1];
                        if (sum > max) max = sum;
                    }
                }
            }
            for (int i = n; i >= 1; i--) {
                for (int j = 2; j <= 2 * i - 1; j += 2) {
                    long sum = 0;
                    int limit = Math.min(j / 2, i - j / 2);
                    for (int k = 0; k < limit; k++) {
                        int row = i - k;
                        int left = j - 2 * k - 1;
                        int right = j;
                        sum += pre[row][right] - pre[row][left];
                        if (sum > max) max = sum;
                    }
                }
            }
            sb.append(tc++).append(". ").append(max).append('\n');
        }
        System.out.print(sb.toString());
    }
}
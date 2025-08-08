import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] needs = new int[n][];
            int[] value = new int[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int k = Integer.parseInt(st.nextToken());
                needs[i] = new int[k];
                for (int j = 0; j < k; j++) {
                    needs[i][j] = Integer.parseInt(st.nextToken()) - 1;
                }
                value[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int[] have = new int[m];
            for (int i = 0; i < m; i++) {
                have[i] = Integer.parseInt(st.nextToken());
            }
            long total = 0;
            for (int i = 0; i < n; i++) {
                int cnt = Integer.MAX_VALUE;
                for (int idx : needs[i]) {
                    cnt = Math.min(cnt, have[idx]);
                }
                if (cnt > 0) {
                    total += (long)cnt * value[i];
                }
            }
            System.out.println(total);
        }
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        int[] starts = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) starts[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] next = new int[K + 1];
        for (int i = 1; i <= K; i++) next[i] = Integer.parseInt(st.nextToken());
        if (M == 1) {
            StringBuilder sb = new StringBuilder();
            for (int v : starts) sb.append(v).append(' ');
            System.out.println(sb.toString().trim());
            return;
        }
        long steps = M - 1;
        int LOG = 0;
        while ((1L << LOG) <= steps) LOG++;
        int[][] up = new int[LOG][K + 1];
        for (int i = 1; i <= K; i++) up[0][i] = next[i];
        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= K; i++) up[j][i] = up[j - 1][ up[j - 1][i] ];
        }
        StringBuilder sb = new StringBuilder();
        for (int s : starts) {
            int cur = s;
            for (int b = 0; b < LOG; b++) {
                if ((steps & (1L << b)) != 0) cur = up[b][cur];
            }
            sb.append(cur).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}
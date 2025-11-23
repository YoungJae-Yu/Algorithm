import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());  // rows(행 수)
        int C = Integer.parseInt(st.nextToken());  // columns(열 수)
        int Q = Integer.parseInt(st.nextToken());  // queries(질의 수)

        long[][] arr = new long[R+1][C+1];
        long[][] ps = new long[R+1][C+1];  // prefix sum(누적합, /ˈpriːfɪks sʌm/)

        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }

        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                ps[i][j] = ps[i-1][j] + ps[i][j-1] - ps[i-1][j-1] + arr[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            long sum = ps[r2][c2] - ps[r1-1][c2] - ps[r2][c1-1] + ps[r1-1][c1-1];
            long count = (long)(r2 - r1 + 1) * (c2 - c1 + 1);
            sb.append(sum / count).append('\n');
        }

        System.out.print(sb.toString());
    }
}
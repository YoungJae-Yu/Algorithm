import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefix = new int[N+1];
        for (int i = 1; i < N; i++) {
            prefix[i] = prefix[i-1] + (a[i] > a[i+1] ? 1 : 0);
        }
        prefix[N] = prefix[N-1];

        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int qi = 0; qi < Q; qi++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(prefix[y-1] - prefix[x-1]).append('\n');
        }
        System.out.print(sb);
    }
}
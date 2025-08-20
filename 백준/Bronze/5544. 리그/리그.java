import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine().trim());
        int[] score = new int[n + 1];
        int m = n * (n - 1) / 2;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (c > d) score[a] += 3;
            else if (c < d) score[b] += 3;
            else { score[a]++; score[b]++; }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int rank = 1;
            for (int j = 1; j <= n; j++) {
                if (score[j] > score[i]) rank++;
            }
            sb.append(rank).append('\n');
        }
        System.out.print(sb.toString());
    }
}
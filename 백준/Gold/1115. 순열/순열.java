import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] p = new int[n];
        for (int i = 0; i < n; i++) p[i] = Integer.parseInt(st.nextToken());
        boolean[] vis = new boolean[n];
        int cycles = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            int cur = i;
            while (!vis[cur]) {
                vis[cur] = true;
                cur = p[cur];
            }
            cycles++;
        }
        System.out.println(cycles == 1 ? 0 : cycles);
    }
}
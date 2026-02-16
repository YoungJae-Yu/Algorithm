import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] parent;
    static int[] color;
    static int[] seen;
    static int timer = 1;
    public static int findLCA(int a, int b) {
        if (a == b) return a;
        timer++;
        int t = timer;
        for (int i = 0; i < 1000; i++) {
            seen[a] = t;
            if (a == 0) break;
            a = parent[a];
        }
        for (int i = 0; i < 1000; i++) {
            if (seen[b] == t) return b;
            b = parent[b];
        }
        return 0;
    }
    public static void paint(int a, int b, int c) {
        int lca = findLCA(a, b);
        while (a != lca) {
            color[a] = c;
            a = parent[a];
        }
        while (b != lca) {
            color[b] = c;
            b = parent[b];
        }
    }
    public static int countColors(int a, int b) {
        int lca = findLCA(a, b);
        HashSet<Integer> s = new HashSet<>();
        while (a != lca) {
            s.add(color[a]);
            a = parent[a];
        }
        while (b != lca) {
            s.add(color[b]);
            b = parent[b];
        }
        return s.size();
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        parent = new int[N];
        color = new int[N];
        seen = new int[N];
        parent[0] = 0;
        for (int i = 1; i < N; i++) parent[i] = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            if (op == 1) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                paint(a, b, c);
            } else if (op == 2) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                parent[a] = b;
            } else {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                sb.append(countColors(a, b)).append('\n');
            }
        }
        System.out.print(sb.toString());
    }
}
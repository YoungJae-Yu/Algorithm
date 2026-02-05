import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = i + 1; j < N; j++) {
                if (s.charAt(j) == 'Y') edges.add(new int[]{i, j});
            }
        }
        if (edges.size() < M) {
            System.out.println(-1);
            return;
        }
        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;
        int[] cnt = new int[N];
        Queue<int[]> leftover = new LinkedList<>();
        int unionCnt = 0;
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            if (union(a, b)) {
                cnt[a]++; cnt[b]++;
                unionCnt++;
            } else {
                leftover.add(e);
            }
        }
        if (unionCnt != N - 1) {
            System.out.println(-1);
            return;
        }
        int need = M - (N - 1);
        for (int k = 0; k < need; k++) {
            if (leftover.isEmpty()) {
                System.out.println(-1);
                return;
            }
            int[] e = leftover.poll();
            cnt[e[0]]++; cnt[e[1]]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (i > 0) sb.append(' ');
            sb.append(cnt[i]);
        }
        System.out.println(sb.toString());
    }
    static int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }
    static boolean union(int a, int b) {
        a = find(a); b = find(b);
        if (a == b) return false;
        if (a < b) parent[b] = a; else parent[a] = b;
        return true;
    }
}
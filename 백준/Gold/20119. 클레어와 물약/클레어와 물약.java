import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer>[] uses = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) uses[i] = new ArrayList<>();
        int[] need = new int[m];
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                int x = Integer.parseInt(st.nextToken());
                uses[x].add(i);
            }
            need[i] = k;
            result[i] = Integer.parseInt(st.nextToken());
        }
        int l = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new ArrayDeque<>();
        HashSet<Integer> have = new HashSet<>();
        for (int i = 0; i < l; i++) {
            int y = Integer.parseInt(st.nextToken());
            if (!have.contains(y)) {
                have.add(y);
                q.offer(y);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int rid : uses[cur]) {
                need[rid]--;
                if (need[rid] == 0) {
                    int prod = result[rid];
                    if (!have.contains(prod)) {
                        have.add(prod);
                        q.offer(prod);
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>(have);
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        sb.append(ans.size()).append('\n');
        for (int v : ans) sb.append(v).append(' ');
        System.out.println(sb.toString().trim());
    }
}
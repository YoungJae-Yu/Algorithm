import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int cost;
        String state;
        Node(int cost, String state) { this.cost = cost; this.state = state; }
        public int compareTo(Node o) { return Integer.compare(this.cost, o.cost); }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sbInit = new StringBuilder();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i > 0) sbInit.append(',');
            sbInit.append(arr[i]);
        }
        String init = sbInit.toString();
        int[] sortedArr = Arrays.copyOf(arr, N);
        Arrays.sort(sortedArr);
        StringBuilder sbT = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (i > 0) sbT.append(',');
            sbT.append(sortedArr[i]);
        }
        String target = sbT.toString();
        int M = Integer.parseInt(br.readLine().trim());
        int[] L = new int[M];
        int[] R = new int[M];
        int[] C = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            L[i] = Integer.parseInt(st.nextToken()) - 1;
            R[i] = Integer.parseInt(st.nextToken()) - 1;
            C[i] = Integer.parseInt(st.nextToken());
        }
        if (isSorted(init)) {
            System.out.println(0);
            return;
        }
        final int INF = Integer.MAX_VALUE / 4;
        Map<String, Integer> dist = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist.put(init, 0);
        pq.add(new Node(0, init));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost != dist.getOrDefault(cur.state, INF)) continue;
            if (cur.state.equals(target)) {
                System.out.println(cur.cost);
                return;
            }
            String[] parts = cur.state.split(",");
            for (int i = 0; i < M; i++) {
                String[] nxt = Arrays.copyOf(parts, parts.length);
                String tmp = nxt[L[i]];
                nxt[L[i]] = nxt[R[i]];
                nxt[R[i]] = tmp;
                String nextState = String.join(",", nxt);
                int nc = cur.cost + C[i];
                if (dist.getOrDefault(nextState, INF) > nc) {
                    dist.put(nextState, nc);
                    pq.add(new Node(nc, nextState));
                }
            }
        }
        System.out.println(-1);
    }
    static boolean isSorted(String s) {
        String[] p = s.split(",");
        for (int i = 1; i < p.length; i++) {
            if (Integer.parseInt(p[i-1]) > Integer.parseInt(p[i])) return false;
        }
        return true;
    }
}
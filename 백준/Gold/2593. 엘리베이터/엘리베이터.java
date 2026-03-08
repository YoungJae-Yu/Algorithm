import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] floor = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) floor[i] = new ArrayList<>();
        ArrayList<Integer>[] elevFloors = new ArrayList[M+1];
        for (int i = 1; i <= M; i++) elevFloors[i] = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int f = x; f <= N; f += y) {
                floor[f].add(i);
                elevFloors[i].add(f);
            }
        }
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        if (A == B) {
            System.out.println(0);
            return;
        }
        boolean[] canReachB = new boolean[M+1];
        for (int i = 1; i <= M; i++) {
            // check if elevator i stops at B
            // since elevFloors[i] is filled, we can check using modular logic or list membership
            // faster: check formula: first floor = elevFloors[i].get(0) and step = elevFloors[i].size()>1 ? elevFloors[i].get(1)-elevFloors[i].get(0) : 0
            // but simpler: check last element equality via loop
            for (int f : elevFloors[i]) if (f == B) { canReachB[i] = true; break; }
        }
        boolean[] visited = new boolean[M+1];
        int[] parent = new int[M+1];
        int[] dist = new int[M+1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int e : floor[A]) {
            if (!visited[e]) {
                visited[e] = true;
                parent[e] = 0;
                dist[e] = 1;
                q.add(e);
            }
        }
        if (q.isEmpty()) {
            System.out.println(-1);
            return;
        }
        int found = -1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (canReachB[cur]) {
                found = cur;
                break;
            }
            for (int f : elevFloors[cur]) {
                for (int ne : floor[f]) {
                    if (!visited[ne]) {
                        visited[ne] = true;
                        parent[ne] = cur;
                        dist[ne] = dist[cur] + 1;
                        q.add(ne);
                    }
                }
                floor[f].clear();
            }
        }
        if (found == -1) {
            System.out.println(-1);
            return;
        }
        LinkedList<Integer> path = new LinkedList<>();
        int cur = found;
        while (cur != 0) {
            path.addFirst(cur);
            cur = parent[cur];
        }
        System.out.println(dist[found]);
        StringBuilder sb = new StringBuilder();
        for (int x : path) sb.append(x).append('\n');
        System.out.print(sb.toString());
    }
}
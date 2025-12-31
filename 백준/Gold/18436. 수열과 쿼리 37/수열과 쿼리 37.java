import java.io.*;
import java.util.*;

public class Main {
    static int[] tree;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());
        int size = 1;
        while (size < N) size <<= 1;
        tree = new int[size << 1];
        build(1, 1, N);
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int idx = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                arr[idx] = x;
                update(1, 1, N, idx, (x % 2 == 0) ? 1 : 0);
            } else if (type == 2) {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                sb.append(query(1, 1, N, l, r)).append('\n');
            } else {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                int even = query(1, 1, N, l, r);
                sb.append((r - l + 1) - even).append('\n');
            }
        }
        System.out.print(sb.toString());
    }

    static void build(int node, int s, int e) {
        if (s == e) {
            tree[node] = (arr[s] % 2 == 0) ? 1 : 0;
            return;
        }
        int mid = (s + e) >> 1;
        build(node << 1, s, mid);
        build(node << 1 | 1, mid + 1, e);
        tree[node] = tree[node << 1] + tree[node << 1 | 1];
    }

    static void update(int node, int s, int e, int idx, int val) {
        if (idx < s || idx > e) return;
        if (s == e) {
            tree[node] = val;
            return;
        }
        int mid = (s + e) >> 1;
        if (idx <= mid) update(node << 1, s, mid, idx, val);
        else update(node << 1 | 1, mid + 1, e, idx, val);
        tree[node] = tree[node << 1] + tree[node << 1 | 1];
    }

    static int query(int node, int s, int e, int l, int r) {
        if (r < s || e < l) return 0;
        if (l <= s && e <= r) return tree[node];
        int mid = (s + e) >> 1;
        return query(node << 1, s, mid, l, r) + query(node << 1 | 1, mid + 1, e, l, r);
    }
}
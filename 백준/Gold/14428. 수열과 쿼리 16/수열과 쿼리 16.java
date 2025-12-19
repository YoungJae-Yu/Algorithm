import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] tree;

    static int build(int node, int s, int e) {
        if (s == e) return tree[node] = s;
        int mid = (s + e) >> 1;
        int l = build(node << 1, s, mid);
        int r = build(node << 1 | 1, mid + 1, e);
        return tree[node] = (arr[l] <= arr[r]) ? l : r;
    }

    static void update(int node, int s, int e, int idx) {
        if (s == e) return;
        int mid = (s + e) >> 1;
        if (idx <= mid) update(node << 1, s, mid, idx);
        else update(node << 1 | 1, mid + 1, e, idx);
        int l = tree[node << 1], r = tree[node << 1 | 1];
        tree[node] = (arr[l] <= arr[r]) ? l : r;
    }

    static int query(int node, int s, int e, int l, int r) {
        if (r < s || e < l) return -1;
        if (l <= s && e <= r) return tree[node];
        int mid = (s + e) >> 1;
        int left = query(node << 1, s, mid, l, r);
        int right = query(node << 1 | 1, mid + 1, e, l, r);
        if (left == -1) return right;
        if (right == -1) return left;
        return (arr[left] <= arr[right]) ? left : right;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        tree = new int[4 * (N + 1)];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());
        build(1, 1, N);
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int idx = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());
                arr[idx] = val;
                update(1, 1, N, idx);
            } else {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                sb.append(query(1, 1, N, l, r)).append('\n');
            }
        }
        System.out.print(sb.toString());
    }
}
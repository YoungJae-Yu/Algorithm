import java.io.*;
import java.util.*;

public class Main {
    static int N, Q;
    static long[] data, tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        data = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) data[i] = Long.parseLong(st.nextToken());
        init();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            long b = Long.parseLong(st.nextToken());
            if (x > y) sb.append(query(1, 0, N - 1, y, x)).append('\n');
            else sb.append(query(1, 0, N - 1, x, y)).append('\n');
            update(1, 0, N - 1, a, b - data[a]);
        }
        System.out.print(sb.toString());
    }

    static void init() {
        int size = 1;
        while (size < N) size <<= 1;
        tree = new long[size << 1];
        build(1, 0, N - 1);
    }

    static long build(int node, int l, int r) {
        if (l == r) return tree[node] = data[l];
        int mid = (l + r) >> 1;
        return tree[node] = build(node << 1, l, mid) + build(node << 1 | 1, mid + 1, r);
    }

    static void update(int node, int l, int r, int idx, long diff) {
        if (idx < l || idx > r) return;
        tree[node] += diff;
        if (l == r) {
            data[idx] += diff;
            return;
        }
        int mid = (l + r) >> 1;
        update(node << 1, l, mid, idx, diff);
        update(node << 1 | 1, mid + 1, r, idx, diff);
    }

    static long query(int node, int l, int r, int ql, int qr) {
        if (qr < l || ql > r) return 0;
        if (ql <= l && r <= qr) return tree[node];
        int mid = (l + r) >> 1;
        return query(node << 1, l, mid, ql, qr) + query(node << 1 | 1, mid + 1, r, ql, qr);
    }
}
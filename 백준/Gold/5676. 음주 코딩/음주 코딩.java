import java.io.*;
import java.util.*;

public class Main {
    static int[] tree;
    static int[] arr;

    static int convert(int v) {
        if (v > 0) return 1;
        if (v < 0) return -1;
        return 0;
    }

    static void build(int node, int s, int e) {
        if (s == e) {
            tree[node] = arr[s];
            return;
        }
        int mid = (s + e) >> 1;
        build(node << 1, s, mid);
        build(node << 1 | 1, mid + 1, e);
        int l = tree[node << 1], r = tree[node << 1 | 1];
        tree[node] = (l == 0 || r == 0) ? 0 : l * r;
    }

    static void update(int node, int s, int e, int idx, int val) {
        if (idx < s || idx > e) return;
        if (s == e) {
            tree[node] = val;
            return;
        }
        int mid = (s + e) >> 1;
        update(node << 1, s, mid, idx, val);
        update(node << 1 | 1, mid + 1, e, idx, val);
        int l = tree[node << 1], r = tree[node << 1 | 1];
        tree[node] = (l == 0 || r == 0) ? 0 : l * r;
    }

    static int query(int node, int s, int e, int l, int r) {
        if (r < s || e < l) return 1;
        if (l <= s && e <= r) return tree[node];
        int mid = (s + e) >> 1;
        int left = query(node << 1, s, mid, l, r);
        int right = query(node << 1 | 1, mid + 1, e, l, r);
        if (left == 0 || right == 0) return 0;
        return left * right;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            StringTokenizer st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            arr = new int[N + 1];
            tree = new int[4 * N + 4];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = convert(Integer.parseInt(st.nextToken()));
            }
            build(1, 1, N);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < K; i++) {
                String cmdLine = br.readLine();
                StringTokenizer st2 = new StringTokenizer(cmdLine);
                char cmd = st2.nextToken().charAt(0);
                int a = Integer.parseInt(st2.nextToken());
                int b = Integer.parseInt(st2.nextToken());
                if (cmd == 'C') {
                    update(1, 1, N, a, convert(b));
                } else {
                    int res = query(1, 1, N, a, b);
                    if (res == 0) sb.append('0');
                    else if (res > 0) sb.append('+');
                    else sb.append('-');
                }
            }
            System.out.println(sb.toString());
        }
    }
}
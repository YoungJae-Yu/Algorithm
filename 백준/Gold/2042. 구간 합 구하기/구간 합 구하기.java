import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;
    static long[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new long[n + 1];
        tree = new long[4 * n];

        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        buildTree(1, 1, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) { // update
                update(1, 1, n, b, c - arr[b]);
                arr[b] = c;
            } else if (a == 2) { // sum query
                sb.append(query(1, 1, n, b, (int) c)).append("\n");
            }
        }
        System.out.print(sb.toString());
    }

    static void buildTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            buildTree(2 * node, start, mid);
            buildTree(2 * node + 1, mid + 1, end);
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

    static void update(int node, int start, int end, int idx, long diff) {
        if (idx < start || idx > end) {
            return;
        }
        tree[node] += diff;
        if (start != end) {
            int mid = (start + end) / 2;
            update(2 * node, start, mid, idx, diff);
            update(2 * node + 1, mid + 1, end, idx, diff);
        }
    }

    static long query(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return query(2 * node, start, mid, left, right) + query(2 * node + 1, mid + 1, end, left, right);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] tree;

    static int init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        int leftMin = init(start, mid, node * 2);
        int rightMin = init(mid + 1, end, node * 2 + 1);
        return tree[node] = Math.min(leftMin, rightMin);
    }

    static int queryMin(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return Integer.MAX_VALUE;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int l = queryMin(start, mid, node * 2, left, right);
        int r = queryMin(mid + 1, end, node * 2 + 1, left, right);
        return Math.min(l, r);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int size = 1;
        while (size < N) size <<= 1;
        size <<= 1;
        tree = new int[size];

        init(0, N - 1, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            sb.append(queryMin(0, N - 1, 1, a, b)).append('\n');
        }
        System.out.print(sb.toString());
    }
}
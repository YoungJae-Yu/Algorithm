import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[] minTree;
    static int[] maxTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 쿼리 개수

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 세그먼트 트리 초기화
        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = (1 << (h + 1));

        minTree = new int[treeSize];
        maxTree = new int[treeSize];

        // 세그먼트 트리 빌드
        buildMinTree(1, 0, N - 1);
        buildMaxTree(1, 0, N - 1);

        // 쿼리 처리
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken()) - 1;
            int minValue = queryMin(1, 0, N - 1, left, right);
            int maxValue = queryMax(1, 0, N - 1, left, right);
            sb.append(minValue).append(" ").append(maxValue).append("\n");
        }

        System.out.print(sb);
    }

    // 최소값 세그먼트 트리 빌드
    static int buildMinTree(int node, int start, int end) {
        if (start == end) {
            return minTree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        return minTree[node] = Math.min(buildMinTree(node * 2, start, mid), buildMinTree(node * 2 + 1, mid + 1, end));
    }

    // 최대값 세그먼트 트리 빌드
    static int buildMaxTree(int node, int start, int end) {
        if (start == end) {
            return maxTree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        return maxTree[node] = Math.max(buildMaxTree(node * 2, start, mid), buildMaxTree(node * 2 + 1, mid + 1, end));
    }

    // 최소값 쿼리
    static int queryMin(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return Integer.MAX_VALUE;
        }
        if (left <= start && end <= right) {
            return minTree[node];
        }
        int mid = (start + end) / 2;
        return Math.min(queryMin(node * 2, start, mid, left, right), queryMin(node * 2 + 1, mid + 1, end, left, right));
    }

    // 최대값 쿼리
    static int queryMax(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return Integer.MIN_VALUE;
        }
        if (left <= start && end <= right) {
            return maxTree[node];
        }
        int mid = (start + end) / 2;
        return Math.max(queryMax(node * 2, start, mid, left, right), queryMax(node * 2 + 1, mid + 1, end, left, right));
    }
}
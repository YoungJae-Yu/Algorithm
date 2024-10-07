import java.io.*;
import java.util.*;

public class Main {
    static int MOD = 1000000007;
    static long[] arr, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 배열의 크기
        int M = Integer.parseInt(st.nextToken()); // 곱 구하는 횟수
        int K = Integer.parseInt(st.nextToken()); // 값 바꾸는 횟수

        arr = new long[N + 1];
        tree = new long[4 * N];

        // 배열 값 입력
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        // 세그먼트 트리 구축
        init(1, N, 1);

        // 쿼리 및 업데이트 처리
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) { // 업데이트
                update(1, N, 1, b, c);
            } else if (a == 2) { // 구간 곱
                System.out.println(multiply(1, N, 1, b, (int) c));
            }
        }
    }

    // 세그먼트 트리 초기화
    static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start] % MOD;
        }

        int mid = (start + end) / 2;
        return tree[node] = (init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1)) % MOD;
    }

    // 구간 곱 구하기
    static long multiply(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return 1; // 곱셈에서 항등원은 1
        }
        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return (multiply(start, mid, node * 2, left, right) * multiply(mid + 1, end, node * 2 + 1, left, right)) % MOD;
    }

    // 세그먼트 트리 업데이트
    static long update(int start, int end, int node, int idx, long val) {
        if (idx < start || idx > end) {
            return tree[node];
        }

        if (start == end) {
            return tree[node] = val % MOD;
        }

        int mid = (start + end) / 2;
        return tree[node] = (update(start, mid, node * 2, idx, val) * update(mid + 1, end, node * 2 + 1, idx, val)) % MOD;
    }
}
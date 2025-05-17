import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] rankList = new int[M][N];

        for (int u = 0; u < M; u++) {
            st = new StringTokenizer(br.readLine());
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            int[] sorted = Arrays.copyOf(A, N);
            Arrays.sort(sorted);
            for (int i = 0; i < N; i++) {
                // 이진 탐색으로 순위(1부터 시작) 찾기
                int idx = Arrays.binarySearch(sorted, A[i]);
                while (idx > 0 && sorted[idx - 1] == A[i]) {
                    idx--;
                }
                rankList[u][i] = idx + 1;
            }
        }

        int answer = 0;
        for (int i = 0; i < M - 1; i++) {
            for (int j = i + 1; j < M; j++) {
                if (Arrays.equals(rankList[i], rankList[j])) {
                    answer++;
                }
            }
        }

        System.out.print(answer);
    }
}
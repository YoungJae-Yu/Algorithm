import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] dpInc = new int[N]; // 증가 부분 수열
        int[] dpDec = new int[N]; // 감소 부분 수열

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            dpInc[i] = 1;
            dpDec[i] = 1;
        }

        // LIS (Longest Increasing Subsequence) 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && dpInc[i] < dpInc[j] + 1) {
                    dpInc[i] = dpInc[j] + 1;
                }
            }
        }

        // LDS (Longest Decreasing Subsequence) 계산 (역순)
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (A[i] > A[j] && dpDec[i] < dpDec[j] + 1) {
                    dpDec[i] = dpDec[j] + 1;
                }
            }
        }

        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            maxLen = Math.max(maxLen, dpInc[i] + dpDec[i] - 1); // -1: 현재 원소 중복 제거
        }

        System.out.println(maxLen);
    }
}

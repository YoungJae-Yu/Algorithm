import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] a = new long[M];
        st = new StringTokenizer(br.readLine());
        long max = 0;
        for (int i = 0; i < M; i++) {
            a[i] = Long.parseLong(st.nextToken());
            if (a[i] > max) max = a[i];
        }
        if (N <= M) {
            System.out.println(N);
            return;
        }
        long left = 1;
        long right = max * N;
        long ansTime = -1;
        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;
            for (int i = 0; i < M; i++) {
                cnt += mid / a[i];
                if (cnt > N) break;
            }
            cnt += M;
            if (cnt >= N) {
                ansTime = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        long prevCnt = 0;
        for (int i = 0; i < M; i++) {
            prevCnt += (ansTime - 1) / a[i];
        }
        prevCnt += M;
        long remain = N - prevCnt;
        int result = -1;
        for (int i = 0; i < M; i++) {
            if (ansTime % a[i] == 0) {
                remain--;
                if (remain == 0) {
                    result = i + 1;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
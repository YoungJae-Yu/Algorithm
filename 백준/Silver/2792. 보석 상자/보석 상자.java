import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] a = new long[M];
        long max = 0;
        for (int i = 0; i < M; i++) {
            a[i] = Long.parseLong(br.readLine().trim());
            if (a[i] > max) max = a[i];
        }
        long left = 1, right = max, ans = max;
        while (left <= right) {
            long mid = (left + right) / 2;
            long need = 0;
            for (int i = 0; i < M; i++) {
                need += (a[i] + mid - 1) / mid;
                if (need > N) break;
            }
            if (need <= N) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        long sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            sum += a[i];
            if (a[i] > max) max = a[i];
        }
        long low = max;
        long high = sum;
        long ans = high;
        while (low <= high) {
            long mid = (low + high) / 2;
            int cnt = 1;
            long cur = 0;
            for (int i = 0; i < N; i++) {
                if (cur + a[i] > mid) {
                    cnt++;
                    cur = a[i];
                } else {
                    cur += a[i];
                }
            }
            if (cnt <= M) {
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
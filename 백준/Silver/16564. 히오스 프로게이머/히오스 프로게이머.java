import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        int[] a = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(br.readLine());
            if (a[i] > max) max = a[i];
        }
        Arrays.sort(a);
        long l = a[0];
        long r = (long) max + K;
        long ans = l;
        while (l <= r) {
            long mid = (l + r) / 2;
            long need = 0;
            for (int i = 0; i < N; i++) {
                if (a[i] < mid) need += (mid - a[i]);
                if (need > K) break;
            }
            if (need <= K) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
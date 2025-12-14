import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long S;
    static long[] a;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        S = Long.parseLong(st.nextToken());
        a = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Long.parseLong(st.nextToken());

        int n1 = n / 2;
        int n2 = n - n1;

        long[] left = new long[1 << n1];
        long[] right = new long[1 << n2];

        for (int mask = 0; mask < (1 << n1); mask++) {
            long sum = 0;
            for (int i = 0; i < n1; i++) if ((mask & (1 << i)) != 0) sum += a[i];
            left[mask] = sum;
        }

        for (int mask = 0; mask < (1 << n2); mask++) {
            long sum = 0;
            for (int i = 0; i < n2; i++) if ((mask & (1 << i)) != 0) sum += a[n1 + i];
            right[mask] = sum;
        }

        Arrays.sort(right);
        long ans = 0;

        for (long x : left) {
            long need = S - x;
            int l = lowerBound(right, need);
            int r = upperBound(right, need);
            ans += (r - l);
        }

        if (S == 0) ans--; 
        System.out.println(ans);
    }

    static int lowerBound(long[] arr, long key) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (arr[m] < key) l = m + 1;
            else r = m;
        }
        return l;
    }

    static int upperBound(long[] arr, long key) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (arr[m] <= key) l = m + 1;
            else r = m;
        }
        return l;
    }
}
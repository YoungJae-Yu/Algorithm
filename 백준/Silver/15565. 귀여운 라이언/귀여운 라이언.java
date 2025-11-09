import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        int l = 0;
        int count = 0;
        int ans = Integer.MAX_VALUE;
        for (int r = 0; r < n; r++) {
            if (a[r] == 1) count++;
            while (count >= k) {
                ans = Math.min(ans, r - l + 1);
                if (a[l] == 1) count--;
                l++;
            }
        }
        if (ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
}
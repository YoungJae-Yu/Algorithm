import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> cnt = new HashMap<>();
        int l = 0, r = 0, ans = 0;
        while (r < N) {
            int v = arr[r];
            int c = cnt.getOrDefault(v, 0);
            if (c < K) {
                cnt.put(v, c + 1);
                r++;
                ans = Math.max(ans, r - l);
            } else {
                int lv = arr[l];
                int lc = cnt.get(lv);
                if (lc == 1) cnt.remove(lv);
                else cnt.put(lv, lc - 1);
                l++;
            }
        }
        System.out.println(ans);
    }
}
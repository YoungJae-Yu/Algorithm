import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(a);
            int ans = 0;
            for (int i = 2; i < n; i++) {
                ans = Math.max(ans, a[i] - a[i - 2]);
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }
}
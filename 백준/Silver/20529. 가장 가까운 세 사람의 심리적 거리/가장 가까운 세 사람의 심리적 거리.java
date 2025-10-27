import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] a = new String[N];
            for (int i = 0; i < N; i++) a[i] = st.nextToken();
            if (N > 32) {
                sb.append(0).append('\n');
                continue;
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    for (int k = j + 1; k < N; k++) {
                        int d = 0;
                        String x = a[i], y = a[j], z = a[k];
                        for (int p = 0; p < 4; p++) {
                            char cx = x.charAt(p), cy = y.charAt(p), cz = z.charAt(p);
                            if (cx != cy) d++;
                            if (cx != cz) d++;
                            if (cy != cz) d++;
                        }
                        if (d < ans) ans = d;
                        if (ans == 0) break;
                    }
                    if (ans == 0) break;
                }
                if (ans == 0) break;
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }
}
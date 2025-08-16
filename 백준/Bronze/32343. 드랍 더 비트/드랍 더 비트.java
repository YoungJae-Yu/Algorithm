import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int limit = 1 << n;
        int ans = 0;
        for (int x = 0; x < limit; x++) {
            if (Integer.bitCount(x) != a) continue;
            for (int y = 0; y < limit; y++) {
                if (Integer.bitCount(y) != b) continue;
                ans = Math.max(ans, x ^ y);
            }
        }
        System.out.println(ans);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> cnt = new HashMap<>();
        int maxCnt = 0;
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            int c = cnt.getOrDefault(x, 0) + 1;
            cnt.put(x, c);
            if (c > maxCnt) {
                maxCnt = c;
            }
        }
        System.out.println(maxCnt <= (N + 1) / 2 ? "YES" : "NO");
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        boolean incPhase = true;
        String ans = "YES";
        for (int i = 1; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur == prev) {
                ans = "NO";
                break;
            }
            if (incPhase) {
                if (cur < prev) {
                    incPhase = false;
                }
            } else {
                if (cur > prev) {
                    ans = "NO";
                    break;
                }
            }
            prev = cur;
        }
        System.out.print(ans);
    }
}
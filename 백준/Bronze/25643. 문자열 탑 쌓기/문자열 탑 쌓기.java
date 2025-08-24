import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String prev = br.readLine();
        boolean possible = true;
        for (int i = 1; i < n; i++) {
            String cur = br.readLine();
            boolean ok = false;
            for (int j = 1; j <= m; j++) {
                if (prev.substring(m - j, m).equals(cur.substring(0, j))) {
                    ok = true;
                    break;
                }
                if (prev.substring(0, j).equals(cur.substring(m - j, m))) {
                    ok = true;
                    break;
                }
            }
            if (!ok) {
                possible = false;
                break;
            }
            prev = cur;
        }
        System.out.println(possible ? 1 : 0);
    }
}
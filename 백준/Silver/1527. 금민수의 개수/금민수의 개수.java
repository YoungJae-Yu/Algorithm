import java.io.*;
import java.util.*;

public class Main {
    static long A, B;
    static int ans = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        dfs(4);
        dfs(7);
        System.out.println(ans);
    }
    static void dfs(long n) {
        if (n > B) return;
        if (n >= A) ans++;
        dfs(n * 10 + 4);
        dfs(n * 10 + 7);
    }
}
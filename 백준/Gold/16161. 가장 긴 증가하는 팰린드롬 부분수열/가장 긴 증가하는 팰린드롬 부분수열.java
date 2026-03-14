import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] a;

    static void input() {
        FastReader fr = new FastReader();
        n = fr.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) a[i] = fr.nextInt();
    }

    static int solve() {
        int ans = 1;
        int left = 0, right = 0;
        while (left <= right && right < n - 1) {
            if (a[right] < a[right + 1]) {
                right++;
                continue;
            }
            if (a[right] == a[right + 1]) {
                int half = 0;
                while (half <= right - left) {
                    int rIdx = right + 1 + half;
                    if (rIdx >= n) break;
                    if (a[right - half] != a[rIdx]) break;
                    half++;
                }
                ans = Math.max(ans, half * 2);
                left = right + 1;
                right++;
                continue;
            }
            if (a[right] > a[right + 1]) {
                int half = 0;
                while (half < right - left) {
                    int lIdx = (right - 1) - half;
                    int rIdx = (right + 1) + half;
                    if (rIdx >= n) break;
                    if (a[lIdx] != a[rIdx]) break;
                    half++;
                }
                ans = Math.max(ans, half * 2 + 1);
                left = right + 1;
                right++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        input();
        System.out.println(solve());
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
    }
}
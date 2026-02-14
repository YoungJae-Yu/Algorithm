import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        if (s == null) s = "";
        if (t == null) t = "";
        int n = s.length(), m = t.length();
        int[][] ps = new int[n + 1][26];
        int[][] pt = new int[m + 1][26];
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            for (int k = 0; k < 26; k++) ps[i + 1][k] = ps[i][k];
            ps[i + 1][c]++;
        }
        for (int i = 0; i < m; i++) {
            int c = t.charAt(i) - 'a';
            for (int k = 0; k < 26; k++) pt[i + 1][k] = pt[i][k];
            pt[i + 1][c]++;
        }
        int max = Math.min(n, m);
        for (int len = max; len >= 1; len--) {
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i + len <= n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < 26; k++) {
                    int cnt = ps[i + len][k] - ps[i][k];
                    sb.append(cnt).append(',');
                }
                set.add(sb.toString());
            }
            for (int j = 0; j + len <= m; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < 26; k++) {
                    int cnt = pt[j + len][k] - pt[j][k];
                    sb.append(cnt).append(',');
                }
                if (set.contains(sb.toString())) {
                    System.out.println(len);
                    return;
                }
            }
        }
        System.out.println(0);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static String T, P;
    static int[] pi;
    static ArrayList<Integer> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = br.readLine();
        P = br.readLine();
        ans = new ArrayList<>();
        getPi();
        kmp();
        StringBuilder sb = new StringBuilder();
        sb.append(ans.size()).append('\n');
        for (int idx : ans) {
            sb.append(idx + 1).append(' ');
        }
        System.out.println(sb.toString());
    }

    static void getPi() {
        int m = P.length();
        pi = new int[m];
        int j = 0;
        for (int i = 1; i < m; i++) {
            while (j > 0 && P.charAt(i) != P.charAt(j)) {
                j = pi[j - 1];
            }
            if (P.charAt(i) == P.charAt(j)) {
                pi[i] = ++j;
            }
        }
    }

    static void kmp() {
        int n = T.length();
        int m = P.length();
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && T.charAt(i) != P.charAt(j)) {
                j = pi[j - 1];
            }
            if (T.charAt(i) == P.charAt(j)) {
                if (j == m - 1) {
                    ans.add(i - m + 1);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
    }
}
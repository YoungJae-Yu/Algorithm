import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static String[] ops;
    static boolean[] used = new boolean[10];
    static String maxResult = null;
    static String minResult = null;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine().trim());
        ops = new String[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) ops[i] = st.nextToken();
        dfsMax(0, "");
        used = new boolean[10];
        dfsMin(0, "");
        System.out.println(maxResult);
        System.out.println(minResult);
    }

    static void dfsMax(int depth, String num) {
        if (depth == k + 1) {
            if (maxResult == null) maxResult = num;
            return;
        }
        for (int d = 9; d >= 0; d--) {
            if (!used[d]) {
                if (depth == 0 || valid(num.charAt(depth - 1) - '0', d, ops[depth - 1])) {
                    used[d] = true;
                    dfsMax(depth + 1, num + d);
                    used[d] = false;
                    if (maxResult != null) return;
                }
            }
        }
    }

    static void dfsMin(int depth, String num) {
        if (depth == k + 1) {
            if (minResult == null) minResult = num;
            return;
        }
        for (int d = 0; d <= 9; d++) {
            if (!used[d]) {
                if (depth == 0 || valid(num.charAt(depth - 1) - '0', d, ops[depth - 1])) {
                    used[d] = true;
                    dfsMin(depth + 1, num + d);
                    used[d] = false;
                    if (minResult != null) return;
                }
            }
        }
    }

    static boolean valid(int a, int b, String op) {
        if ("<".equals(op)) return a < b;
        else return a > b;
    }
}
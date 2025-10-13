import java.io.*;
import java.util.*;

public class Main {
    static int[] inorder;
    static int[] tree;
    static int K, n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        n = (1<<K) - 1;
        inorder = new int[n];
        StringTokenizer st = new StringTokenizer("");
        int idx = 0;
        while (idx < n) {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            while (st.hasMoreTokens() && idx < n) {
                inorder[idx++] = Integer.parseInt(st.nextToken());
            }
        }
        tree = new int[n+1];
        build(0, n-1, 1);
        StringBuilder sb = new StringBuilder();
        for (int level = 0; level < K; level++) {
            int from = 1<<level;
            int to = (1<<(level+1)) - 1;
            for (int i = from; i <= to; i++) {
                sb.append(tree[i]).append(' ');
            }
            sb.setLength(sb.length()-1);
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
    static void build(int s, int e, int idx) {
        if (s > e) return;
        int mid = (s + e) / 2;
        tree[idx] = inorder[mid];
        build(s, mid-1, idx*2);
        build(mid+1, e, idx*2+1);
    }
}
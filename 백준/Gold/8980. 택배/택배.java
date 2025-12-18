import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String next() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return null;
            if (line.length() == 0) continue;
            st = new StringTokenizer(line);
        }
        String tok = st.nextToken();
        if (tok.length() > 0 && tok.charAt(0) == '\uFEFF') tok = tok.substring(1);
        return tok;
    }

    static int nextInt() throws Exception {
        return Integer.parseInt(next());
    }

    public static void main(String[] args) throws Exception {
        int N = nextInt();
        int capacity = nextInt();
        int M = nextInt();
        class Req implements Comparable<Req> {
            int from, to, box;
            Req(int f, int t, int b) { from = f; to = t; box = b; }
            public int compareTo(Req o) {
                if (to != o.to) return to - o.to;
                return from - o.from;
            }
        }
        List<Req> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int a = nextInt();
            int b = nextInt();
            int c = nextInt();
            list.add(new Req(a, b, c));
        }
        Collections.sort(list);
        int[] remain = new int[N + 1];
        for (int i = 1; i <= N; i++) remain[i] = capacity;
        long ans = 0;
        for (Req r : list) {
            int can = Integer.MAX_VALUE;
            for (int i = r.from; i < r.to; i++) {
                can = Math.min(can, remain[i]);
            }
            int take = Math.min(can, r.box);
            if (take <= 0) continue;
            for (int i = r.from; i < r.to; i++) {
                remain[i] -= take;
            }
            ans += take;
        }
        System.out.println(ans);
    }
}
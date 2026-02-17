import java.io.BufferedInputStream;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int N = fs.nextInt();
        int Q = fs.nextInt();
        HashSet<Integer>[] S = new HashSet[N + 1];
        for (int i = 1; i <= N; i++) S[i] = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            int cnt = fs.nextInt();
            for (int j = 0; j < cnt; j++) S[i].add(fs.nextInt());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int op = fs.nextInt();
            if (op == 1) {
                int a = fs.nextInt();
                int b = fs.nextInt();
                if (a == b) continue;
                if (S[a].size() < S[b].size()) {
                    HashSet<Integer> tmp = S[a];
                    S[a] = S[b];
                    S[b] = tmp;
                }
                S[a].addAll(S[b]);
                S[b].clear();
            } else {
                int a = fs.nextInt();
                sb.append(S[a].size()).append('\n');
            }
        }
        System.out.print(sb.toString());
    }

    static class FastScanner {
        private final BufferedInputStream in = new BufferedInputStream(System.in);
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private int read() throws Exception {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws Exception {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) return -1;
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}
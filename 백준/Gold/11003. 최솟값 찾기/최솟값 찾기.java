import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int N = fs.nextInt();
        int L = fs.nextInt();
        StringBuilder sb = new StringBuilder();
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int x = fs.nextInt();
            while (!dq.isEmpty() && dq.peekLast()[0] > x) dq.pollLast();
            dq.addLast(new int[]{x, i});
            while (!dq.isEmpty() && dq.peekFirst()[1] <= i - L) dq.pollFirst();
            sb.append(dq.peekFirst()[0]);
            if (i != N - 1) sb.append(' ');
        }
        System.out.print(sb.toString());
    }

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= 32) {
                if (c == -1) return -1;
            }
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            int val = 0;
            while (c > 32) {
                val = val * 10 + c - '0';
                c = read();
            }
            return val * sign;
        }
    }
}
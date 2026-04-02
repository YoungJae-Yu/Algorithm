import java.io.*;
import java.util.*;

public class Main {
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
            do {
                c = read();
            } while (c <= 32 && c != -1);

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > 32 && c != -1) {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder sb = new StringBuilder();

        int n = fs.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) a[i] = fs.nextInt();

        ArrayList<Integer> cuts = new ArrayList<>();
        int mx = 0;
        for (int i = 1; i <= n; i++) {
            if (a[i] > mx) mx = a[i];
            if (mx == i) cuts.add(i);
        }

        sb.append(cuts.size()).append('\n');
        int prev = 0;
        for (int end : cuts) {
            int cnt = end - prev;
            sb.append(cnt);
            for (int i = prev + 1; i <= end; i++) {
                sb.append(' ').append(i);
            }
            sb.append('\n');
            prev = end;
        }

        System.out.print(sb.toString());
    }
}
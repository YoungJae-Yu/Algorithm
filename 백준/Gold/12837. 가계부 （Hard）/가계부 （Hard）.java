import java.io.InputStream;

public class Main {
    static int n;
    static long[] bit;

    static void add(int idx, long val){
        for(; idx <= n; idx += idx & -idx) bit[idx] += val;
    }

    static long sum(int idx){
        long s = 0;
        for(; idx > 0; idx -= idx & -idx) s += bit[idx];
        return s;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        n = fs.nextInt();
        int q = fs.nextInt();
        bit = new long[n + 1];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++){
            int op = fs.nextInt();
            if(op == 1){
                int p = fs.nextInt();
                long x = fs.nextLong();
                add(p, x);
            } else {
                int p = fs.nextInt();
                int qq = fs.nextInt();
                long res = sum(qq) - sum(p - 1);
                sb.append(res).append('\n');
            }
        }
        System.out.print(sb.toString());
    }

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws Exception {
            if(ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if(len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws Exception {
            int c;
            while((c = read()) <= ' ') if(c == -1) return -1;
            int neg = 0;
            if(c == '-') { neg = 1; c = read(); }
            int val = c - '0';
            while((c = read()) > ' ') val = val * 10 + c - '0';
            return neg == 1 ? -val : val;
        }

        long nextLong() throws Exception {
            int c;
            while((c = read()) <= ' ') if(c == -1) return -1;
            int neg = 0;
            if(c == '-') { neg = 1; c = read(); }
            long val = c - '0';
            while((c = read()) > ' ') val = val * 10 + c - '0';
            return neg == 1 ? -val : val;
        }
    }
}
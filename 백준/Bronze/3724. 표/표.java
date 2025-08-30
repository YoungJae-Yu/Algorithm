import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        int T = Integer.parseInt(nextToken(br, st));
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(nextLineNonEmpty(br));
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            BigInteger[] prod = new BigInteger[m];
            for (int i = 0; i < m; i++) prod[i] = BigInteger.ONE;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(nextLineNonEmpty(br));
                for (int j = 0; j < m; j++) {
                    int v = Integer.parseInt(st.nextToken());
                    prod[j] = prod[j].multiply(BigInteger.valueOf(v));
                }
            }
            int ansIdx = 1;
            BigInteger max = prod[0];
            for (int j = 1; j < m; j++) {
                int cmp = prod[j].compareTo(max);
                if (cmp > 0 || cmp == 0) {
                    max = prod[j];
                    ansIdx = j + 1;
                }
            }
            sb.append(ansIdx).append('\n');
        }
        System.out.print(sb.toString());
    }

    private static String nextLineNonEmpty(BufferedReader br) throws IOException {
        String s;
        do {
            s = br.readLine();
            if (s == null) return "";
        } while (s.trim().isEmpty());
        return s;
    }

    private static String nextToken(BufferedReader br, StringTokenizer st) throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = nextLineNonEmpty(br);
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }
}
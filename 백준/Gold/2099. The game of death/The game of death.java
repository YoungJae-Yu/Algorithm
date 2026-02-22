import java.io.*;
import java.util.*;

public class Main {
    static BitSet[] multiply(BitSet[] A, BitSet[] B, int n) {
        BitSet[] Bcols = new BitSet[n];
        for (int j = 0; j < n; j++) {
            Bcols[j] = new BitSet(n);
            for (int i = 0; i < n; i++) {
                if (B[i].get(j)) Bcols[j].set(i);
            }
        }
        BitSet[] C = new BitSet[n];
        for (int i = 0; i < n; i++) {
            C[i] = new BitSet(n);
            for (int j = 0; j < n; j++) {
                if (A[i].intersects(Bcols[j])) C[i].set(j);
            }
        }
        return C;
    }

    static BitSet[] power(BitSet[] base, long exp, int n) {
        BitSet[] result = new BitSet[n];
        for (int i = 0; i < n; i++) {
            result[i] = new BitSet(n);
            result[i].set(i);
        }
        while (exp > 0) {
            if ((exp & 1) == 1) result = multiply(result, base, n);
            base = multiply(base, base, n);
            exp >>= 1;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        BitSet[] A = new BitSet[N];
        for (int i = 0; i < N; i++) A[i] = new BitSet(N);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            A[i].set(x);
            A[i].set(y);
        }
        BitSet[] AK = power(A, K, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            if (AK[a].get(b)) sb.append("death\n");
            else sb.append("life\n");
        }
        System.out.print(sb.toString());
    }
}
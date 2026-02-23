import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1000000007L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = br.readLine().trim().split("\\s+");
        long N = Long.parseLong(sp[0]);
        int M = Integer.parseInt(sp[1]);
        if (N < M) {
            System.out.println(1);
            return;
        }
        if (N == M) {
            System.out.println(2);
            return;
        }
        int m = M;
        long[][] T = new long[m][m];
        for (int i = 0; i < m - 1; i++) T[i][i + 1] = 1;
        T[m - 1][0] = 1;
        T[m - 1][m - 1] = 1;
        long exp = N - M;
        long[][] R = matPow(T, exp, MOD);
        long[] V = new long[m];
        for (int i = 0; i < m - 1; i++) V[i] = 1;
        V[m - 1] = 2;
        long ans = 0;
        for (int i = 0; i < m; i++) {
            ans = (ans + (R[m - 1][i] * V[i]) % MOD) % MOD;
        }
        System.out.println(ans);
    }

    static long[][] matMul(long[][] A, long[][] B, long mod) {
        int n = A.length;
        long[][] C = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;
                long aik = A[i][k];
                for (int j = 0; j < n; j++) {
                    C[i][j] = (C[i][j] + aik * B[k][j]) % mod;
                }
            }
        }
        return C;
    }

    static long[][] matPow(long[][] A, long e, long mod) {
        int n = A.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) res[i][i] = 1;
        long[][] base = A;
        while (e > 0) {
            if ((e & 1) == 1) res = matMul(res, base, mod);
            base = matMul(base, base, mod);
            e >>= 1;
        }
        return res;
    }
}
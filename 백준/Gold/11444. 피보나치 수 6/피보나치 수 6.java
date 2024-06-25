import java.util.Scanner;

public class Main {
    private static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        scanner.close();
        System.out.println(fibonacci(n));
    }

    private static long[][] matrixMult(long[][] A, long[][] B) {
        return new long[][] {
            {(A[0][0] * B[0][0] + A[0][1] * B[1][0]) % MOD, (A[0][0] * B[0][1] + A[0][1] * B[1][1]) % MOD},
            {(A[1][0] * B[0][0] + A[1][1] * B[1][0]) % MOD, (A[1][0] * B[0][1] + A[1][1] * B[1][1]) % MOD}
        };
    }

    private static long[][] matrixPow(long[][] matrix, long exp) {
        long[][] result = {{1, 0}, {0, 1}}; // 단위 행렬
        long[][] base = matrix;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = matrixMult(result, base);
            }
            base = matrixMult(base, base);
            exp /= 2;
        }

        return result;
    }

    private static long fibonacci(long n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        long[][] F = {{1, 1}, {1, 0}};
        long[][] result = matrixPow(F, n - 1);
        return result[0][0];
    }
}
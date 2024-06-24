import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] matrix;
    static final int MOD = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 행렬 크기와 거듭제곱 횟수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        // 행렬 입력
        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        // 행렬 거듭제곱 계산
        int[][] result = matrixPower(matrix, B);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static int[][] matrixPower(int[][] base, long exp) {
        int[][] result = new int[N][N];
        
        // 단위 행렬로 초기화
        for (int i = 0; i < N; i++) {
            result[i][i] = 1;
        }

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = multiply(result, base);
            }
            base = multiply(base, base);
            exp /= 2;
        }

        return result;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] result = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                    result[i][j] %= MOD;
                }
            }
        }

        return result;
    }
}
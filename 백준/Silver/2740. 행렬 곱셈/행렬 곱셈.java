import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 행렬 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        int[][] A = new int[n1][m1];
        
        for (int i = 0; i < n1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m1; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 두 번째 행렬 입력
        st = new StringTokenizer(br.readLine());
        int m2 = Integer.parseInt(st.nextToken());
        int k2 = Integer.parseInt(st.nextToken());
        int[][] B = new int[m2][k2];
        
        for (int i = 0; i < m2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k2; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 행렬 곱셈 결과를 저장할 행렬
        int[][] C = new int[n1][k2];
        
        // 행렬 곱셈 수행
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < k2; j++) {
                for (int l = 0; l < m1; l++) {
                    C[i][j] += A[i][l] * B[l][j];
                }
            }
        }
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < k2; j++) {
                sb.append(C[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.print(sb.toString());
    }
}
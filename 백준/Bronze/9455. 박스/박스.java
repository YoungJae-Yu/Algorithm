import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        
        StringBuilder sb = new StringBuilder();
        
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 행의 수
            int n = Integer.parseInt(st.nextToken()); // 열의 수
            
            int[][] grid = new int[m][n];
            
            // 격자 입력
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int totalMoves = 0;
            
            // 각 열에 대해 계산
            for (int j = 0; j < n; j++) {
                int boxCount = 0; // 해당 열의 박스 개수
                int emptyBelow = 0; // 박스 아래의 빈 공간
                
                // 아래에서 위로 순회
                for (int i = m - 1; i >= 0; i--) {
                    if (grid[i][j] == 1) {
                        // 박스를 발견하면 그 아래의 빈 공간만큼 이동해야 함
                        totalMoves += emptyBelow;
                        boxCount++;
                    } else {
                        // 빈 공간이면 아래에 있는 박스들이 이동해야 하므로 카운트 증가
                        emptyBelow = emptyBelow + 1;
                    }
                }
            }
            
            sb.append(totalMoves).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}
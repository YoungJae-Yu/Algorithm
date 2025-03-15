import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 두 단어 입력
        String A = sc.next();
        String B = sc.next();
        
        // 교차점 찾기
        int row = -1;  // B에서 위치 (세로)
        int col = -1;  // A에서 위치 (가로)
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    col = i;
                    row = j;
                    break;
                }
            }
            if (row != -1) break;
        }
        
        // 그리드 생성 (B의 길이 × A의 길이)
        char[][] grid = new char[B.length()][A.length()];
        
        // 그리드를 '.'으로 초기화
        for (int i = 0; i < B.length(); i++) {
            for (int j = 0; j < A.length(); j++) {
                grid[i][j] = '.';
            }
        }
        
        // 가로 단어 A 배치
        for (int i = 0; i < A.length(); i++) {
            grid[row][i] = A.charAt(i);
        }
        
        // 세로 단어 B 배치
        for (int i = 0; i < B.length(); i++) {
            grid[i][col] = B.charAt(i);
        }
        
        // 결과 출력
        for (int i = 0; i < B.length(); i++) {
            System.out.println(new String(grid[i]));
        }
        
        sc.close();
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[1001][1001];
        int[] areas = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();
            int h = sc.nextInt();
            
            for (int j = x; j < x + w; j++) {
                for (int k = y; k < y + h; k++) {
                    grid[j][k] = i;
                }
            }
        }
        
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                if (grid[i][j] != 0) {
                    areas[grid[i][j]]++;
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            System.out.println(areas[i]);
        }
    }
}
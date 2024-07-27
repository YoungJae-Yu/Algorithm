import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int M, N, H;
    static int[][][] boxes;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();
        boxes = new int[H][N][M];
        
        Queue<int[]> queue = new LinkedList<>();
        int unripeCount = 0;
        
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    boxes[h][n][m] = sc.nextInt();
                    if (boxes[h][n][m] == 1) {
                        queue.add(new int[]{h, n, m});
                    } else if (boxes[h][n][m] == 0) {
                        unripeCount++;
                    }
                }
            }
        }
        
        if (unripeCount == 0) {
            System.out.println(0);
            return;
        }
        
        int days = -1;
        
        while (!queue.isEmpty()) {
            days++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int z = pos[0], y = pos[1], x = pos[2];
                
                for (int d = 0; d < 6; d++) {
                    int nz = z + dz[d];
                    int ny = y + dy[d];
                    int nx = x + dx[d];
                    
                    if (nz >= 0 && nz < H && ny >= 0 && ny < N && nx >= 0 && nx < M && boxes[nz][ny][nx] == 0) {
                        boxes[nz][ny][nx] = 1;
                        queue.add(new int[]{nz, ny, nx});
                        unripeCount--;
                    }
                }
            }
        }
        
        System.out.println(unripeCount == 0 ? days : -1);
    }
}
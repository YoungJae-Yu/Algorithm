import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int[][] dist = new int[V + 1][V + 1];
        
        for (int i = 1; i <= V; i++) {
            Arrays.fill(dist[i], 10000000);
            dist[i][i] = 0;
        }
        
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            dist[u][v] = w;
        }
        
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        int result = 10000000;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i != j && dist[i][j] + dist[j][i] < result) {
                    result = dist[i][j] + dist[j][i];
                }
            }
        }
        
        if (result == 10000000) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}
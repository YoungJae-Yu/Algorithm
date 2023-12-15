import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] points;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            points = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
            }

            boolean[] visited = new boolean[N];
            double result = findMinVectorSum(0, visited, 0);
            System.out.println(result);
        }
    }

    static double findMinVectorSum(int idx, boolean[] visited, int count) {
        if (count == N / 2) {
            return calculateVectorSum(visited);
        }

        double minSum = Double.MAX_VALUE;
        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                minSum = Math.min(minSum, findMinVectorSum(i + 1, visited, count + 1));
                visited[i] = false;
            }
        }
        return minSum;
    }

    static double calculateVectorSum(boolean[] visited) {
        double sumX = 0, sumY = 0;
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                sumX += points[i][0];
                sumY += points[i][1];
            } else {
                sumX -= points[i][0];
                sumY -= points[i][1];
            }
        }
        return Math.sqrt(sumX * sumX + sumY * sumY);
    }
}

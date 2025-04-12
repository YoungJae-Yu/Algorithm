import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int rows = str.length() / k;
        char[][] grid = new char[rows][k];

        int idx = 0;
        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < k; j++) {
                    grid[i][j] = str.charAt(idx++);
                }
            } else {
                for (int j = k - 1; j >= 0; j--) {
                    grid[i][j] = str.charAt(idx++);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < rows; i++) {
                sb.append(grid[i][j]);
            }
        }

        System.out.println(sb.toString());
    }
}
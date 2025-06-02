import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        int R = Integer.parseInt(rc[0]);
        int C = Integer.parseInt(rc[1]);
        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int[] ans = new int[5];
        for (int i = 0; i < R - 1; i++) {
            for (int j = 0; j < C - 1; j++) {
                boolean hasBuilding = false;
                int carCount = 0;
                if (map[i][j] == '#') hasBuilding = true;
                else if (map[i][j] == 'X') carCount++;
                if (map[i][j + 1] == '#') hasBuilding = true;
                else if (map[i][j + 1] == 'X') carCount++;
                if (map[i + 1][j] == '#') hasBuilding = true;
                else if (map[i + 1][j] == 'X') carCount++;
                if (map[i + 1][j + 1] == '#') hasBuilding = true;
                else if (map[i + 1][j + 1] == 'X') carCount++;
                if (!hasBuilding) {
                    ans[carCount]++;
                }
            }
        }
        for (int k = 0; k <= 4; k++) {
            System.out.println(ans[k]);
        }
    }
}
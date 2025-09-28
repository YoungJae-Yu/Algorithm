import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);
        int[][] a = new int[n][m];
        int[][] b = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) a[i][j] = line.charAt(j) - '0';
        }
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) b[i][j] = line.charAt(j) - '0';
        }
        int cnt = 0;
        if (n < 3 || m < 3) {
            boolean eq = true;
            for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) if (a[i][j] != b[i][j]) eq = false;
            System.out.println(eq ? 0 : -1);
            return;
        }
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                if (a[i][j] != b[i][j]) {
                    cnt++;
                    for (int x = 0; x < 3; x++) for (int y = 0; y < 3; y++) a[i + x][j + y] = 1 - a[i + x][j + y];
                }
            }
        }
        boolean equal = true;
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) if (a[i][j] != b[i][j]) equal = false;
        System.out.println(equal ? cnt : -1);
    }
}
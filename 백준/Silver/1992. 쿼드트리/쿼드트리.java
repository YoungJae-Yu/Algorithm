import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int[][] video;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        video = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                video[i][j] = line.charAt(j) - '0';
            }
        }

        divideAndConquer(0, 0, n);
        System.out.println(sb.toString());
    }

    public static void divideAndConquer(int x, int y, int size) {
        if (checkColor(x, y, size)) {
            sb.append(video[x][y]);
            return;
        }

        int newSize = size / 2;
        sb.append('(');

        divideAndConquer(x, y, newSize);
        divideAndConquer(x, y + newSize, newSize);
        divideAndConquer(x + newSize, y, newSize);
        divideAndConquer(x + newSize, y + newSize, newSize);

        sb.append(')');
    }

    public static boolean checkColor(int x, int y, int size) {
        int color = video[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (video[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
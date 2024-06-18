import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int[][] paper;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(line[j]);
            }
        }

        divideAndConquer(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void divideAndConquer(int x, int y, int size) {
        if (checkColor(x, y, size)) {
            if (paper[x][y] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;

        divideAndConquer(x, y, newSize);
        divideAndConquer(x, y + newSize, newSize);
        divideAndConquer(x + newSize, y, newSize);
        divideAndConquer(x + newSize, y + newSize, newSize);
    }

    public static boolean checkColor(int x, int y, int size) {
        int color = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
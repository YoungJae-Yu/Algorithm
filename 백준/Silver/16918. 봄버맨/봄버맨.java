import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        long N = Long.parseLong(st.nextToken());
        char[][] grid0 = new char[R][C];
        for (int i = 0; i < R; i++) grid0[i] = br.readLine().toCharArray();

        if (N == 1) {
            printGrid(grid0);
        } else if (N % 2 == 0) {
            printFull(R, C);
        } else {
            char[][] s3 = explode(grid0, R, C);
            if (N % 4 == 3) {
                printGrid(s3);
            } else {
                char[][] s5 = explode(s3, R, C);
                printGrid(s5);
            }
        }
    }

    static char[][] explode(char[][] g, int R, int C) {
        boolean[][] clear = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (g[i][j] == 'O') {
                    clear[i][j] = true;
                    if (i > 0) clear[i - 1][j] = true;
                    if (i < R - 1) clear[i + 1][j] = true;
                    if (j > 0) clear[i][j - 1] = true;
                    if (j < C - 1) clear[i][j + 1] = true;
                }
            }
        }
        char[][] res = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                res[i][j] = clear[i][j] ? '.' : 'O';
            }
        }
        return res;
    }

    static void printGrid(char[][] g) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < g.length; i++) {
            sb.append(new String(g[i])).append('\n');
        }
        System.out.print(sb.toString());
    }

    static void printFull(int R, int C) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) sb.append('O');
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
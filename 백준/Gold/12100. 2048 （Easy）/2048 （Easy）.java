import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(parts[j]);
            }
        }
        dfs(0, board);
        System.out.println(answer);
    }

    static void dfs(int depth, int[][] b) {
        if (depth == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    answer = Math.max(answer, b[i][j]);
                }
            }
            return;
        }
        for (int dir = 0; dir < 4; dir++) {
            int[][] nb = move(b, dir);
            dfs(depth + 1, nb);
        }
    }

    // dir: 0 = up, 1 = down, 2 = left, 3 = right
    static int[][] move(int[][] b, int dir) {
        int[][] nb = new int[N][N];
        for (int i = 0; i < N; i++)
            nb[i] = Arrays.copyOf(b[i], N);

        if (dir == 0) {              // up
            for (int col = 0; col < N; col++) {
                int idx = 0;
                int last = 0;
                for (int row = 0; row < N; row++) {
                    if (nb[row][col] == 0) continue;
                    int v = nb[row][col];
                    nb[row][col] = 0;
                    if (last == 0) {
                        last = v;
                    } else {
                        if (last == v) {
                            nb[idx][col] = v * 2;
                            idx++; last = 0;
                        } else {
                            nb[idx][col] = last;
                            idx++; last = v;
                        }
                    }
                }
                if (last != 0) {
                    nb[idx][col] = last;
                }
            }
        } else if (dir == 1) {       // down
            for (int col = 0; col < N; col++) {
                int idx = N - 1;
                int last = 0;
                for (int row = N - 1; row >= 0; row--) {
                    if (nb[row][col] == 0) continue;
                    int v = nb[row][col];
                    nb[row][col] = 0;
                    if (last == 0) {
                        last = v;
                    } else {
                        if (last == v) {
                            nb[idx][col] = v * 2;
                            idx--; last = 0;
                        } else {
                            nb[idx][col] = last;
                            idx--; last = v;
                        }
                    }
                }
                if (last != 0) {
                    nb[idx][col] = last;
                }
            }
        } else if (dir == 2) {       // left
            for (int row = 0; row < N; row++) {
                int idx = 0;
                int last = 0;
                for (int col = 0; col < N; col++) {
                    if (nb[row][col] == 0) continue;
                    int v = nb[row][col];
                    nb[row][col] = 0;
                    if (last == 0) {
                        last = v;
                    } else {
                        if (last == v) {
                            nb[row][idx] = v * 2;
                            idx++; last = 0;
                        } else {
                            nb[row][idx] = last;
                            idx++; last = v;
                        }
                    }
                }
                if (last != 0) {
                    nb[row][idx] = last;
                }
            }
        } else if (dir == 3) {       // right
            for (int row = 0; row < N; row++) {
                int idx = N - 1;
                int last = 0;
                for (int col = N - 1; col >= 0; col--) {
                    if (nb[row][col] == 0) continue;
                    int v = nb[row][col];
                    nb[row][col] = 0;
                    if (last == 0) {
                        last = v;
                    } else {
                        if (last == v) {
                            nb[row][idx] = v * 2;
                            idx--; last = 0;
                        } else {
                            nb[row][idx] = last;
                            idx--; last = v;
                        }
                    }
                }
                if (last != 0) {
                    nb[row][idx] = last;
                }
            }
        }
        return nb;
    }
}
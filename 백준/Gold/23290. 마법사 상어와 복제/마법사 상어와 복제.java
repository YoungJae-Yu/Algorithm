import java.io.*;
import java.util.*;

public class Main {
    static final int N = 4;
    static int[] fdx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] fdy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] sdx = {-1, 0, 1, 0};
    static int[] sdy = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[][] fish = new ArrayList[N][N];
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) fish[i][j] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());
            fish[x][y].add(d);
        }
        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken()) - 1;
        int sy = Integer.parseInt(st.nextToken()) - 1;
        int[][] smell = new int[N][N];
        for (int time = 1; time <= S; time++) {
            ArrayList<Integer>[][] copy = new ArrayList[N][N];
            for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) copy[i][j] = new ArrayList<>(fish[i][j]);
            ArrayList<Integer>[][] moved = new ArrayList[N][N];
            for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) moved[i][j] = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int idx = 0; idx < fish[i][j].size(); idx++) {
                        int d = fish[i][j].get(idx);
                        int nd = d;
                        boolean movedFlag = false;
                        for (int k = 0; k < 8; k++) {
                            int nx = i + fdx[nd];
                            int ny = j + fdy[nd];
                            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                                if (!(nx == sx && ny == sy) && smell[nx][ny] == 0) {
                                    moved[nx][ny].add(nd);
                                    movedFlag = true;
                                    break;
                                }
                            }
                            nd = (nd == 1) ? 8 : nd - 1;
                        }
                        if (!movedFlag) moved[i][j].add(d);
                    }
                }
            }
            int bestEat = -1;
            int[] bestRoute = new int[3];
            for (int a = 0; a < 4; a++) {
                for (int b = 0; b < 4; b++) {
                    for (int c = 0; c < 4; c++) {
                        int x = sx, y = sy;
                        boolean ok = true;
                        boolean[][] visited = new boolean[N][N];
                        int eat = 0;
                        int[] seq = {a, b, c};
                        for (int k = 0; k < 3; k++) {
                            x += sdx[seq[k]];
                            y += sdy[seq[k]];
                            if (x < 0 || y < 0 || x >= N || y >= N) {
                                ok = false;
                                break;
                            }
                            if (!visited[x][y]) {
                                visited[x][y] = true;
                                eat += moved[x][y].size();
                            }
                        }
                        if (!ok) continue;
                        if (eat > bestEat) {
                            bestEat = eat;
                            bestRoute[0] = a; bestRoute[1] = b; bestRoute[2] = c;
                        }
                    }
                }
            }
            ArrayList<Integer>[][] temp = new ArrayList[N][N];
            for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) temp[i][j] = new ArrayList<>(moved[i][j]);
            int x = sx, y = sy;
            for (int k = 0; k < 3; k++) {
                int dir = bestRoute[k];
                x += sdx[dir];
                y += sdy[dir];
                if (temp[x][y].size() > 0) {
                    temp[x][y].clear();
                    smell[x][y] = time;
                }
            }
            sx = x; sy = y;
            for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) fish[i][j] = new ArrayList<>(temp[i][j]);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (smell[i][j] != 0 && time - smell[i][j] == 2) smell[i][j] = 0;
                }
            }
            for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) if (!copy[i][j].isEmpty()) fish[i][j].addAll(copy[i][j]);
        }
        int ans = 0;
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) ans += fish[i][j].size();
        System.out.println(ans);
    }
}
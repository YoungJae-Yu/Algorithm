import java.io.*;
import java.util.*;

public class Main {
    static class Shark {
        int r, c, s, d, z;
        Shark(int r, int c, int s, int d, int z) {
            this.r = r; this.c = c; this.s = s; this.d = d; this.z = z;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Shark[][] grid = new Shark[R+1][C+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            grid[r][c] = new Shark(r, c, s, d, z);
        }
        long result = 0;
        for (int col = 1; col <= C; col++) {
            for (int row = 1; row <= R; row++) {
                if (grid[row][col] != null) {
                    result += grid[row][col].z;
                    grid[row][col] = null;
                    break;
                }
            }
            Shark[][] ng = new Shark[R+1][C+1];
            for (int r = 1; r <= R; r++) {
                for (int c = 1; c <= C; c++) {
                    if (grid[r][c] == null) continue;
                    Shark sh = grid[r][c];
                    int nr = sh.r;
                    int nc = sh.c;
                    int nd = sh.d;
                    if (nd == 1 || nd == 2) {
                        if (R == 1) {
                            nr = 1;
                        } else {
                            int cycle = (R - 1) * 2;
                            int move = sh.s % cycle;
                            for (int m = 0; m < move; m++) {
                                if (nd == 1) {
                                    if (nr == 1) { nd = 2; nr++; }
                                    else nr--;
                                } else {
                                    if (nr == R) { nd = 1; nr--; }
                                    else nr++;
                                }
                            }
                        }
                    } else {
                        if (C == 1) {
                            nc = 1;
                        } else {
                            int cycle = (C - 1) * 2;
                            int move = sh.s % cycle;
                            for (int m = 0; m < move; m++) {
                                if (nd == 4) {
                                    if (nc == 1) { nd = 3; nc++; }
                                    else nc--;
                                } else {
                                    if (nc == C) { nd = 4; nc--; }
                                    else nc++;
                                }
                            }
                        }
                    }
                    if (ng[nr][nc] == null) {
                        ng[nr][nc] = new Shark(nr, nc, sh.s, nd, sh.z);
                    } else {
                        if (ng[nr][nc].z < sh.z) {
                            ng[nr][nc] = new Shark(nr, nc, sh.s, nd, sh.z);
                        }
                    }
                }
            }
            grid = ng;
        }
        System.out.println(result);
    }
}
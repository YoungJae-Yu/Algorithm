import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static List<int[]> orig = new ArrayList<>();
    static int n;
    static int ans = Integer.MAX_VALUE;
    static int[][] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] a = new char[5][5];
        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 5; j++) a[i][j] = s.charAt(j);
        }
        for (int i = 0; i < 5; i++) for (int j = 0; j < 5; j++) if (a[i][j] == '*') orig.add(new int[]{i, j});
        n = orig.size();
        if (n <= 1) {
            System.out.println(0);
            return;
        }
        List<int[]> cells = new ArrayList<>();
        for (int i = 0; i < 5; i++) for (int j = 0; j < 5; j++) cells.add(new int[]{i, j});
        select(new ArrayList<>(), 0, cells);
        System.out.println(ans);
    }

    static void select(List<int[]> sel, int start, List<int[]> cells) {
        if (sel.size() == n) {
            if (!connected(sel)) return;
            dist = new int[n][n];
            for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) {
                int[] o = orig.get(i);
                int[] t = sel.get(j);
                dist[i][j] = Math.abs(o[0]-t[0]) + Math.abs(o[1]-t[1]);
            }
            permuteAndCalc();
            return;
        }
        for (int i = start; i < 25; i++) {
            sel.add(cells.get(i));
            select(sel, i+1, cells);
            sel.remove(sel.size()-1);
        }
    }

    static boolean connected(List<int[]> sel) {
        boolean[][] used = new boolean[5][5];
        for (int[] p : sel) used[p[0]][p[1]] = true;
        boolean[][] vis = new boolean[5][5];
        Queue<int[]> q = new LinkedList<>();
        int[] first = sel.get(0);
        q.add(first);
        vis[first[0]][first[1]] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            cnt++;
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if (!used[nx][ny] || vis[nx][ny]) continue;
                vis[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
        return cnt == n;
    }

    static boolean[] usedPerm;
    static int[] order;
    static void permuteAndCalc() {
        usedPerm = new boolean[n];
        order = new int[n];
        dfsPerm(0, 0);
    }

    static void dfsPerm(int idx, int sum) {
        if (sum >= ans) return;
        if (idx == n) {
            ans = Math.min(ans, sum);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (usedPerm[j]) continue;
            usedPerm[j] = true;
            dfsPerm(idx+1, sum + dist[idx][j]);
            usedPerm[j] = false;
        }
    }
}
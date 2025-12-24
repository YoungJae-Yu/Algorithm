import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] A;
    static int[] drOrder = {0, -1, 1, 0, 0};
    static int[] dcOrder = {0, 0, 0, -1, 1};
    static int[] spiralR;
    static int[] spiralC;
    static int[][] idxMap;
    static int len;
    static int[] arr;
    static long score1 = 0, score2 = 0, score3 = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) A[i][j] = Integer.parseInt(st.nextToken());
        }
        makeSpiral();
        arr = new int[len + 1];
        fillArrFromBoard();
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            doBlizzard(d, s);
            compress();
            while (explode()) {
                compress();
            }
            transform();
        }
        long ans = score1 * 1 + score2 * 2 + score3 * 3;
        System.out.println(ans);
    }

    static void makeSpiral() {
        int total = N * N;
        spiralR = new int[total];
        spiralC = new int[total];
        idxMap = new int[N][N];
        int r = N / 2;
        int c = N / 2;
        int idx = 0;
        int step = 1;
        int[][] dirs = {{0,0},{0,-1},{1,0},{0,1},{-1,0}}; // left, down, right, up as pairs swapped for loop
        int[] dr = {0, 0, 1, 0, -1};
        int[] dc = {0, -1, 0, 1, 0};
        int dir = 1;
        while (true) {
            for (int k = 0; k < 2; k++) {
                for (int s = 0; s < step; s++) {
                    r += dr[dir];
                    c += dc[dir];
                    if (r < 0 || r >= N || c < 0 || c >= N) break;
                    spiralR[++idx] = r;
                    spiralC[idx] = c;
                    if (r == 0 && c == 0) break;
                }
                dir = dir % 4 + 1;
                if (r == 0 && c == 0) break;
            }
            if (r == 0 && c == 0) break;
            step++;
        }
        len = idx;
        for (int i = 1; i <= len; i++) {
            idxMap[spiralR[i]][spiralC[i]] = i;
        }
    }

    static void fillArrFromBoard() {
        for (int i = 1; i <= len; i++) {
            arr[i] = A[spiralR[i]][spiralC[i]];
        }
    }

    static void doBlizzard(int d, int s) {
        int r = N / 2;
        int c = N / 2;
        int[] dr = {0, -1, 1, 0, 0};
        int[] dc = {0, 0, 0, -1, 1};
        for (int dist = 1; dist <= s; dist++) {
            int nr = r + dr[d] * dist;
            int nc = c + dc[d] * dist;
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            int idx = idxMap[nr][nc];
            if (idx >= 1 && idx <= len) arr[idx] = 0;
        }
    }

    static void compress() {
        int[] tmp = new int[len + 1];
        int p = 1;
        for (int i = 1; i <= len; i++) {
            if (arr[i] != 0) {
                tmp[p++] = arr[i];
            }
        }
        arr = tmp;
    }

    static boolean explode() {
        boolean any = false;
        int i = 1;
        while (i <= len) {
            if (arr[i] == 0) { i++; continue; }
            int j = i + 1;
            while (j <= len && arr[j] == arr[i]) j++;
            int cnt = j - i;
            if (cnt >= 4) {
                any = true;
                int val = arr[i];
                for (int k = i; k < j; k++) {
                    if (val == 1) score1++;
                    else if (val == 2) score2++;
                    else if (val == 3) score3++;
                    arr[k] = 0;
                }
            }
            i = j;
        }
        return any;
    }

    static void transform() {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 1;
        while (i <= len) {
            if (arr[i] == 0) break;
            int j = i + 1;
            while (j <= len && arr[j] == arr[i]) j++;
            int cnt = j - i;
            list.add(cnt);
            list.add(arr[i]);
            i = j;
        }
        int[] newArr = new int[len + 1];
        int p = 1;
        for (int v : list) {
            if (p > len) break;
            newArr[p++] = v;
        }
        arr = newArr;
    }
}
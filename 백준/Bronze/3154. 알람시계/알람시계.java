import java.io.*;
import java.util.*;

public class Main {
    static int[][] pos = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(":");
        int H = Integer.parseInt(t[0]);
        int M = Integer.parseInt(t[1]);
        int bestI = 0, bestJ = 0, best = Integer.MAX_VALUE;
        for (int i = 0; i < 100; i++) {
            if (i % 24 != H) continue;
            for (int j = 0; j < 100; j++) {
                if (j % 60 != M) continue;
                int a = i / 10, b = i % 10, c = j / 10, d = j % 10;
                int cost = dist(a,b) + dist(b,c) + dist(c,d);
                if (cost < best) {
                    best = cost;
                    bestI = i;
                    bestJ = j;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (bestI < 10) sb.append('0');
        sb.append(bestI);
        sb.append(':');
        if (bestJ < 10) sb.append('0');
        sb.append(bestJ);
        System.out.println(sb.toString());
    }

    static int dist(int x, int y) {
        return Math.abs(pos[x][0] - pos[y][0]) + Math.abs(pos[x][1] - pos[y][1]);
    }
}
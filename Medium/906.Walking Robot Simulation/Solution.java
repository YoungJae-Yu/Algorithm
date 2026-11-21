import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Long> set = new HashSet<>();
        for (int[] o : obstacles) {
            set.add(key(o[0], o[1]));
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0, y = 0, d = 0, best = 0;
        for (int c : commands) {
            if (c == -2) {
                d = (d + 3) % 4;
            } else if (c == -1) {
                d = (d + 1) % 4;
            } else {
                for (int i = 0; i < c; i++) {
                    int nx = x + dx[d], ny = y + dy[d];
                    if (set.contains(key(nx, ny))) break;
                    x = nx;
                    y = ny;
                    best = Math.max(best, x * x + y * y);
                }
            }
        }
        return best;
    }

    private long key(int x, int y) {
        return ((long) x << 32) ^ (y & 0xffffffffL);
    }
}
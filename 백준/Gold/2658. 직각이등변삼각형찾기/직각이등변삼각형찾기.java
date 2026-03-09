import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int n = 10;
    static int[][] p = new int[10][10];
    static int[][] d = new int[10][10];

    static boolean isValid(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    static boolean chk() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (p[i][j] != d[i][j]) return false;
            }
        }
        return true;
    }

    static boolean go0(int x, int y, int l) {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < i + 1; j++) {
                int nx = i + x, ny = j + y;
                if (!isValid(nx, ny)) return false;
                d[nx][ny] = 1;
            }
        }
        return true;
    }

    static boolean go1(int x, int y, int l) {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l - i; j++) {
                int nx = i + x, ny = j + y;
                if (!isValid(nx, ny)) return false;
                d[nx][ny] = 1;
            }
        }
        return true;
    }

    static boolean go2(int x, int y, int l) {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j > i - l; j--) {
                int nx = i + x, ny = j + y;
                if (!isValid(nx, ny)) return false;
                d[nx][ny] = 1;
            }
        }
        return true;
    }

    static boolean go3(int x, int y, int l) {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j > -(i + 1); j--) {
                int nx = i + x, ny = j + y;
                if (!isValid(nx, ny)) return false;
                d[nx][ny] = 1;
            }
        }
        return true;
    }

    static boolean go4(int x, int y, int l) {
        return (l & 1) == 1 && go0(x - l / 2, y, l / 2 + 1) && go1(x, y, l / 2 + 1);
    }

    static boolean go5(int x, int y, int l) {
        return (l & 1) == 1 && go1(x, y, l / 2 + 1) && go2(x, y, l / 2 + 1);
    }

    static boolean go6(int x, int y, int l) {
        return (l & 1) == 1 && go3(x - l / 2, y, l / 2) && go2(x, y, l / 2 + 1);
    }

    static boolean go7(int x, int y, int l) {
        return (l & 1) == 1 && go0(x, y, l / 2 + 1) && go3(x, y, l / 2 + 1);
    }

    static interface TriMaker {
        boolean make(int x, int y, int l);
    }

    static TriMaker[] makers = new TriMaker[] {
        Main::go0, Main::go1, Main::go2, Main::go3, Main::go4, Main::go5, Main::go6, Main::go7
    };

    static List<int[]> getAns(int k, int x, int y, int l) {
        List<int[]> ans = new ArrayList<>();
        if (k == 0) {
            ans.add(new int[]{x, y});
            ans.add(new int[]{x + l - 1, y});
            ans.add(new int[]{x + l - 1, y + l - 1});
        } else if (k == 1) {
            ans.add(new int[]{x, y});
            ans.add(new int[]{x, y + l - 1});
            ans.add(new int[]{x + l - 1, y});
        } else if (k == 2) {
            ans.add(new int[]{x, y});
            ans.add(new int[]{x + l - 1, y});
            ans.add(new int[]{x, y - (l - 1)});
        } else if (k == 3) {
            ans.add(new int[]{x, y});
            ans.add(new int[]{x + l - 1, y});
            ans.add(new int[]{x + l - 1, y - (l - 1)});
        } else if (k == 4) {
            ans.add(new int[]{x - l / 2, y});
            ans.add(new int[]{x + l / 2, y});
            ans.add(new int[]{x, y + l / 2});
        } else if (k == 5) {
            ans.add(new int[]{x, y + l / 2});
            ans.add(new int[]{x, y - l / 2});
            ans.add(new int[]{x + l / 2, y});
        } else if (k == 6) {
            ans.add(new int[]{x - l / 2, y});
            ans.add(new int[]{x + l / 2, y});
            ans.add(new int[]{x, y - l / 2});
        } else if (k == 7) {
            ans.add(new int[]{x, y});
            ans.add(new int[]{x + l / 2, y + l / 2});
            ans.add(new int[]{x + l / 2, y - l / 2});
        }
        Collections.sort(ans, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < n; i++) {
            String s = br.readLine().trim();
            for (int j = 0; j < n; j++) {
                p[i][j] = s.charAt(j) - '0';
            }
        }

        for (int k = 0; k < 8; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int l = 2; l < n + 1; l++) {
                        for (int a = 0; a < 10; a++) for (int b = 0; b < 10; b++) d[a][b] = 0;
                        if (makers[k].make(i, j, l) && chk()) {
                            List<int[]> ans = getAns(k, i + 1, j + 1, l);
                            StringBuilder sb = new StringBuilder();
                            for (int[] v : ans) {
                                sb.append(v[0]).append(' ').append(v[1]).append('\n');
                            }
                            System.out.print(sb.toString());
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }
}
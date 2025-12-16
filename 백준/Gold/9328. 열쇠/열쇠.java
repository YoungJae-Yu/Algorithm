import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            char[][] map = new char[h + 2][w + 2];
            for (int i = 0; i < h + 2; i++) Arrays.fill(map[i], '.');
            for (int i = 1; i <= h; i++) {
                String line = br.readLine();
                while (line.length() == 0) line = br.readLine();
                for (int j = 1; j <= w; j++) map[i][j] = line.charAt(j - 1);
            }
            String keysLine = br.readLine().trim();
            int keys = 0;
            if (!keysLine.equals("0")) {
                for (char c : keysLine.toCharArray()) keys |= 1 << (c - 'a');
            }
            boolean[][] visited = new boolean[h + 2][w + 2];
            ArrayDeque<int[]> q = new ArrayDeque<>();
            @SuppressWarnings("unchecked")
            ArrayDeque<int[]>[] doorQ = new ArrayDeque[26];
            for (int i = 0; i < 26; i++) doorQ[i] = new ArrayDeque<>();
            q.add(new int[] {0, 0});
            visited[0][0] = true;
            int ans = 0;
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            while (!q.isEmpty()) {
                int[] p = q.poll();
                int x = p[0], y = p[1];
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d], ny = y + dy[d];
                    if (nx < 0 || nx >= h + 2 || ny < 0 || ny >= w + 2) continue;
                    if (visited[nx][ny]) continue;
                    char c = map[nx][ny];
                    if (c == '*') continue;
                    if (c == '.') {
                        visited[nx][ny] = true;
                        q.add(new int[] {nx, ny});
                    } else if (c == '$') {
                        ans++;
                        map[nx][ny] = '.';
                        visited[nx][ny] = true;
                        q.add(new int[] {nx, ny});
                    } else if (c >= 'a' && c <= 'z') {
                        int idx = c - 'a';
                        if ((keys & (1 << idx)) == 0) {
                            keys |= 1 << idx;
                            while (!doorQ[idx].isEmpty()) {
                                int[] pos = doorQ[idx].poll();
                                visited[pos[0]][pos[1]] = true;
                                q.add(pos);
                            }
                        }
                        map[nx][ny] = '.';
                        visited[nx][ny] = true;
                        q.add(new int[] {nx, ny});
                    } else if (c >= 'A' && c <= 'Z') {
                        int idx = c - 'A';
                        if ((keys & (1 << idx)) != 0) {
                            map[nx][ny] = '.';
                            visited[nx][ny] = true;
                            q.add(new int[] {nx, ny});
                        } else {
                            doorQ[idx].add(new int[] {nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }
}
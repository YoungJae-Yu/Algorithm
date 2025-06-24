import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String s = br.readLine();
        boolean[][] visited = new boolean[2001][2001];
        int x = 1000, y = 1000, count = 1;
        visited[x][y] = true;
        for (char c : s.toCharArray()) {
            if (c == 'E') x++;
            else if (c == 'W') x--;
            else if (c == 'S') y--;
            else if (c == 'N') y++;
            if (!visited[x][y]) {
                visited[x][y] = true;
                count++;
            }
        }
        System.out.print(count);
    }
}
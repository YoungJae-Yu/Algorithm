import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = { 0, 1 };
	static int[] dx = { 1, 0 };
	static int board[][];
	static boolean used[][];
	static StringBuilder sb;
	static boolean printed;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int index = 0;
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			board = new int[9][9];
			used = new boolean[10][10];
			for (int i = 0; i < 10; i++)
				used[i][i] = true;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int U = Integer.parseInt(st.nextToken());
				String LU = st.nextToken();
				int V = Integer.parseInt(st.nextToken());
				String LV = st.nextToken();
				board[LU.charAt(0) - 'A'][LU.charAt(1) - '1'] = U;
				board[LV.charAt(0) - 'A'][LV.charAt(1) - '1'] = V;
				used[U][V] = true;
				used[V][U] = true;
			}
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= 9; i++) {
				String t = st.nextToken();
				board[t.charAt(0) - 'A'][t.charAt(1) - '1'] = i;
			}
			sb.append("Puzzle ").append(++index).append("\n");
			printed = false;
			dfs(0);
		}
		System.out.println(sb);
	}
	private static void dfs(int count) {
		if (count == 81) {
			if (printed) return;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++)
					sb.append(board[i][j]);
				sb.append("\n");
			}
			printed = true;
			return;
		}
		int y = count / 9;
		int x = count % 9;
		if (board[y][x] != 0) {
			dfs(count + 1);
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if (board[y][x] != 0 || !check(i, y, x))
				continue;
			for (int d = 0; d < dy.length; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (ny < 0 || ny >= 9 || nx < 0 || nx >= 9 || board[ny][nx] != 0)
					continue;
				for (int j = 1; j <= 9; j++) {
					if (used[i][j] || !check(j, ny, nx))
						continue;
					board[y][x] = i;
					board[ny][nx] = j;
					used[i][j] = used[j][i] = true;
					dfs(count + 1);
					board[y][x] = 0;
					board[ny][nx] = 0;
					used[i][j] = used[j][i] = false;
				}
			}
		}
	}
	private static boolean check(int num, int y, int x) {
		int startY = y / 3 * 3;
		int startX = x / 3 * 3;
		for (int i = 0; i < 9; i++) {
			if (board[y][i] == num) return false;
			if (board[i][x] == num) return false;
			if (board[startY + i / 3][startX + i % 3] == num) return false;
		}
		return true;
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        // 누적합 배열
        int[][] blackStart = new int[N + 1][M + 1];
        int[][] whiteStart = new int[N + 1][M + 1];

        // 누적 합 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                blackStart[i][j] = blackStart[i - 1][j] + blackStart[i][j - 1] - blackStart[i - 1][j - 1];
                whiteStart[i][j] = whiteStart[i - 1][j] + whiteStart[i][j - 1] - whiteStart[i - 1][j - 1];

                if ((i + j) % 2 == 0) {
                    if (board[i - 1][j - 1] == 'B') {
                        whiteStart[i][j]++;
                    } else {
                        blackStart[i][j]++;
                    }
                } else {
                    if (board[i - 1][j - 1] == 'B') {
                        blackStart[i][j]++;
                    } else {
                        whiteStart[i][j]++;
                    }
                }
            }
        }

        int minChanges = Integer.MAX_VALUE;

        // K x K 체스판을 검사하며 최소 변경 수 찾기
        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                int changesBlackStart = blackStart[i][j] - blackStart[i - K][j] - blackStart[i][j - K] + blackStart[i - K][j - K];
                int changesWhiteStart = whiteStart[i][j] - whiteStart[i - K][j] - whiteStart[i][j - K] + whiteStart[i - K][j - K];

                int changes = Math.min(changesBlackStart, changesWhiteStart);
                minChanges = Math.min(minChanges, changes);
            }
        }

        System.out.println(minChanges);
    }
}
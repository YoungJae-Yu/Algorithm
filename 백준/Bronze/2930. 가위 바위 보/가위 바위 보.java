import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int getScore(char a, char b) {
        if (a == b) return 1;
        if (a == 'R') return (b == 'S') ? 2 : 0;
        if (a == 'S') return (b == 'P') ? 2 : 0;
        if (a == 'P') return (b == 'R') ? 2 : 0;
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int R = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int N = Integer.parseInt(br.readLine());
        char[][] friends = new char[N][R];
        for (int i = 0; i < N; i++) {
            friends[i] = br.readLine().toCharArray();
        }

        int honestScore = 0;
        int maxScore = 0;
        char[] moves = {'R', 'S', 'P'};

        for (int i = 0; i < R; i++) {
            // 정직하게 낸 점수 누적
            for (int j = 0; j < N; j++) {
                honestScore += getScore(s.charAt(i), friends[j][i]);
            }
            // 각 모양별로 최댓값 계산
            int best = 0;
            for (char m : moves) {
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    sum += getScore(m, friends[j][i]);
                }
                if (sum > best) best = sum;
            }
            maxScore += best;
        }

        System.out.println(honestScore);
        System.out.println(maxScore);
    }
}
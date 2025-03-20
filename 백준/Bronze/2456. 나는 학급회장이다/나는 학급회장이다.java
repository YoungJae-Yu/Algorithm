import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] votes = new int[4][4]; // 후보 1~3번의 [1점, 2점, 3점] 투표 수 및 총점
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= 3; j++) {
                int score = sc.nextInt();
                votes[j][score]++;
                votes[j][0] += score;
            }
        }
        sc.close();

        int winner = 0, maxScore = 0;
        boolean tie = false;

        for (int i = 1; i <= 3; i++) {
            if (votes[i][0] > maxScore) {
                maxScore = votes[i][0];
                winner = i;
                tie = false;
            } else if (votes[i][0] == maxScore) {
                if (votes[i][3] > votes[winner][3]) {
                    winner = i;
                    tie = false;
                } else if (votes[i][3] == votes[winner][3] && votes[i][2] > votes[winner][2]) {
                    winner = i;
                    tie = false;
                } else if (votes[i][3] == votes[winner][3] && votes[i][2] == votes[winner][2]) {
                    tie = true;
                }
            }
        }

        if (tie) {
            System.out.println("0 " + maxScore);
        } else {
            System.out.println(winner + " " + maxScore);
        }
    }
}
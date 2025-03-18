import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] scores = new int[N][3];
        
        // 점수 입력 받기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = sc.nextInt();
            }
        }
        
        int[] totalScores = new int[N];

        // 3 라운드에 대해 처리
        for (int j = 0; j < 3; j++) {
            Map<Integer, Integer> freq = new HashMap<>();
            
            // 해당 라운드의 점수 빈도 계산
            for (int i = 0; i < N; i++) {
                freq.put(scores[i][j], freq.getOrDefault(scores[i][j], 0) + 1);
            }

            // 유니크한 점수만 합산
            for (int i = 0; i < N; i++) {
                if (freq.get(scores[i][j]) == 1) {
                    totalScores[i] += scores[i][j];
                }
            }
        }

        // 결과 출력
        for (int score : totalScores) {
            System.out.println(score);
        }

        sc.close();
    }
}
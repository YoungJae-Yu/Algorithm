import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();

        int[][] square = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < M; j++) {
                square[i][j] = line.charAt(j) - '0'; // char를 int로 변환
            }
        }

        int maxSize = 1; // 최소 크기는 1
        // 정사각형 검사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 최소 2x2부터 검사 시작
                for (int size = 1; size < Math.min(N, M); size++) {
                    // 범위 확인
                    if (i + size < N && j + size < M) {
                        // 꼭짓점 값이 같은지 확인
                        if (square[i][j] == square[i + size][j] &&
                            square[i][j] == square[i][j + size] &&
                            square[i][j] == square[i + size][j + size]) {
                            maxSize = Math.max(maxSize, (size + 1) * (size + 1)); // 정사각형 크기 갱신
                        }
                    }
                }
            }
        }
        System.out.println(maxSize); // 최대 정사각형 크기 출력
    }
}

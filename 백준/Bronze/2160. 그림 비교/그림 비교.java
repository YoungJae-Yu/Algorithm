import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        char[][][] pictures = new char[N][5][7];

        // 그림 입력 받기
        for (int n = 0; n < N; n++) {
            for (int i = 0; i < 5; i++) {
                String line = scanner.next();
                for (int j = 0; j < 7; j++) {
                    pictures[n][i][j] = line.charAt(j);
                }
            }
        }

        int minDifference = Integer.MAX_VALUE;
        int pic1 = -1, pic2 = -1;

        // 모든 그림 쌍 비교
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int difference = 0;
                for (int x = 0; x < 5; x++) {
                    for (int y = 0; y < 7; y++) {
                        if (pictures[i][x][y] != pictures[j][x][y]) {
                            difference++;
                        }
                    }
                }
                if (difference < minDifference) {
                    minDifference = difference;
                    pic1 = i + 1;
                    pic2 = j + 1;
                }
            }
        }

        System.out.println(pic1 + " " + pic2);
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int R = scanner.nextInt();
        int C = scanner.nextInt();
        int ZR = scanner.nextInt();
        int ZC = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 소비

        char[][] article = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < C; j++) {
                article[i][j] = line.charAt(j);
            }
        }

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < R; i++) {
            for (int zr = 0; zr < ZR; zr++) {
                for (int j = 0; j < C; j++) {
                    for (int zc = 0; zc < ZC; zc++) {
                        output.append(article[i][j]);
                    }
                }
                output.append("\n");
            }
        }

        System.out.print(output.toString());

        scanner.close();
    }
}
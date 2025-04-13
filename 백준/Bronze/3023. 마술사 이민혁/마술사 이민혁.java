import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();

        char[][] quarter = new char[R][C];
        for (int i = 0; i < R; i++) {
            quarter[i] = sc.nextLine().toCharArray();
        }

        int A = sc.nextInt();
        int B = sc.nextInt();

        int totalRows = 2 * R;
        int totalCols = 2 * C;
        char[][] full = new char[totalRows][totalCols];

        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                int mirroredRow = i < R ? i : 2 * R - 1 - i;
                int mirroredCol = j < C ? j : 2 * C - 1 - j;
                full[i][j] = quarter[mirroredRow][mirroredCol];
            }
        }

        int errorRow = A - 1;
        int errorCol = B - 1;
        full[errorRow][errorCol] = full[errorRow][errorCol] == '#' ? '.' : '#';

        for (int i = 0; i < totalRows; i++) {
            System.out.println(new String(full[i]));
        }
    }
}
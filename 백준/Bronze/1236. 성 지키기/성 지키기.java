import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] castle = new char[n][m];

        for (int i = 0; i < n; i++) {
            String row = scanner.next();
            for (int j = 0; j < m; j++) {
                castle[i][j] = row.charAt(j);
            }
        }

        boolean[] rowHasGuard = new boolean[n];
        boolean[] colHasGuard = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (castle[i][j] == 'X') {
                    rowHasGuard[i] = true;
                    colHasGuard[j] = true;
                }
            }
        }

        int rowCount = 0;
        for (boolean hasGuard : rowHasGuard) {
            if (!hasGuard) rowCount++;
        }

        int colCount = 0;
        for (boolean hasGuard : colHasGuard) {
            if (!hasGuard) colCount++;
        }

        System.out.println(Math.max(rowCount, colCount));
    }
}
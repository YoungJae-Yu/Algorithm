import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rows = new String[5];
        for (int i = 0; i < 5; i++) rows[i] = br.readLine();
        int n = rows[0].length();
        char[][] s = new char[5][n];
        for (int i = 0; i < 5; i++) s[i] = rows[i].toCharArray();
        for (int j = 0; j < n; j++) {
            if (s[2][j] == 'm') {
                s[0][j] = 'o';
                s[1][j] = 'w';
                s[2][j] = 'l';
                s[3][j] = 'n';
                s[4][j] = '.';
            } else if (s[2][j] == 'l') {
                s[0][j] = '.';
                s[1][j] = 'o';
                s[2][j] = 'm';
                s[3][j] = 'l';
                s[4][j] = 'n';
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.setLength(0);
            for (int j = 0; j < n; j++) sb.append(s[i][j]);
            System.out.println(sb.toString());
        }
    }
}
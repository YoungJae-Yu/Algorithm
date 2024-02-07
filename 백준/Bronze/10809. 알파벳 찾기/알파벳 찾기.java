import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String S = scanner.next();
        int[] positions = new int[26];
        Arrays.fill(positions, -1);

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (positions[c - 'a'] == -1) {
                positions[c - 'a'] = i;
            }
        }

        for (int position : positions) {
            System.out.print(position + " ");
        }
    }
}

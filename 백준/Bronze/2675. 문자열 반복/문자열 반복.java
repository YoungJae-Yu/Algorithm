import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int R = scanner.nextInt();
            String S = scanner.next();
            StringBuilder P = new StringBuilder();

            for (char c : S.toCharArray()) {
                for (int j = 0; j < R; j++) {
                    P.append(c);
                }
            }

            System.out.println(P);
        }
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < T; i++) {
            String S = scanner.nextLine();
            System.out.println(S.charAt(0) + "" + S.charAt(S.length() - 1));
        }
    }
}

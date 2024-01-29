import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean[] submitted = new boolean[31];

        for (int i = 0; i < 28; i++) {
            int studentNumber = scanner.nextInt();
            submitted[studentNumber] = true;
        }

        for (int i = 1; i <= 30; i++) {
            if (!submitted[i]) {
                System.out.println(i);
            }
        }
    }
}

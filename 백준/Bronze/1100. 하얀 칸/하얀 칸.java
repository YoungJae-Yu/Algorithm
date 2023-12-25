import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        for (int i = 0; i < 8; i++) {
            String line = scanner.next();
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0 && j % 2 == 0 && line.charAt(j) == 'F') {
                    count++;
                } else if (i % 2 == 1 && j % 2 == 1 && line.charAt(j) == 'F') {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}

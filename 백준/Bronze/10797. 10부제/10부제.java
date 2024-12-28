import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        int count = 0;

        for (int i = 0; i < 5; i++) {
            if (scanner.nextInt() == day) {
                count++;
            }
        }
        
        System.out.println(count);
        scanner.close();
    }
}
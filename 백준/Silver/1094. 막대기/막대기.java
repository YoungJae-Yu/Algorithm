import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int stickLength = 64;
        int count = 0;

        while (X > 0) {
            if (stickLength > X) {
                stickLength /= 2;
            } else {
                X -= stickLength;
                count++;
            }
        }

        System.out.println(count);
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = reverse(scanner.nextInt());
        int B = reverse(scanner.nextInt());

        System.out.println(Math.max(A, B));
    }

    private static int reverse(int number) {
        return (number % 10) * 100 + (number / 10 % 10) * 10 + number / 100;
    }
}

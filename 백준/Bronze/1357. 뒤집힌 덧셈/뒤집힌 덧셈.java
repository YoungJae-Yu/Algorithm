import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        sc.close();

        int revX = reverse(X);
        int revY = reverse(Y);
        int sum = revX + revY;
        int result = reverse(sum);

        System.out.println(result);
    }

    private static int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
}
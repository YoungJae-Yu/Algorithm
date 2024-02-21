import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.close();

        StringBuilder sb = new StringBuilder();
        while (N > 0) {
            int remainder = N % B;
            if (remainder < 10) {
                sb.append(remainder);
            } else {
                sb.append((char) (remainder - 10 + 'A'));
            }
            N /= B;
        }

        System.out.println(sb.reverse().toString());
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int original = N;
        int count = 0;

        do {
            int sum = (N / 10) + (N % 10);
            N = (N % 10) * 10 + (sum % 10);
            count++;
        } while (original != N);

        System.out.println(count);
    }
}

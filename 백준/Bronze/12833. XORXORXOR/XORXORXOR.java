import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        if (C % 2 == 0) {
            System.out.println(A);
        } else {
            System.out.println(A ^ B);
        }
    }
}
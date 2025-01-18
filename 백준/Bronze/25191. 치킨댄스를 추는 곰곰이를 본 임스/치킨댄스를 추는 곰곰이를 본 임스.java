import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();

        int maxChicken = A / 2 + B;
        System.out.println(Math.min(N, maxChicken));
    }
}
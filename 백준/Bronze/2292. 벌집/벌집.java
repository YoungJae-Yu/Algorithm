import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextInt();
        int count = 1;
        long range = 2;
        long increment = 6;

        if (N != 1) {
            while (range <= N) {
                range += increment;
                increment += 6;
                count++;
            }
        }

        System.out.println(count);
    }
}

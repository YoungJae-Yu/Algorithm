import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long length = 3;
        for (int i = 1; i < N; i++) {
            length += (length - 1);
        }
        long result = length * length;

        System.out.println(result);

        sc.close();
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int C = sc.nextInt();
            
            int Q = C / 25;
            C %= 25;
            int D = C / 10;
            C %= 10;
            int N = C / 5;
            C %= 5;
            int P = C;
            
            System.out.println(Q + " " + D + " " + N + " " + P);
        }

        sc.close();
    }
}

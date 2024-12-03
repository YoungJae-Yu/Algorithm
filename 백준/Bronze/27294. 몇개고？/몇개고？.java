import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 시간 (1 <= T <= 24)
        int S = sc.nextInt(); // 술 여부 (0 또는 1)

        if (S == 1 || T < 12 || T > 16) {
            System.out.println(280);
        } else {
            System.out.println(320);
        }
    }
}
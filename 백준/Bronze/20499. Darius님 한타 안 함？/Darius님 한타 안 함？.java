import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] kda = input.split("/");
        int K = Integer.parseInt(kda[0]);
        int D = Integer.parseInt(kda[1]);
        int A = Integer.parseInt(kda[2]);

        if (D == 0 || K + A < D) {
            System.out.println("hasu");
        } else {
            System.out.println("gosu");
        }
    }
}
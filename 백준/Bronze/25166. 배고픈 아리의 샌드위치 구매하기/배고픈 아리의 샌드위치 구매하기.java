import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int M = sc.nextInt();
        if (S <= 1023) {
            System.out.println("No thanks");
        } else {
            int need = S - 1023;
            if ((need & M) == need) {
                System.out.println("Thanks");
            } else {
                System.out.println("Impossible");
            }
        }
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int minO = Math.min(m, k);
        int minX = Math.min(n - m, n - k);

        System.out.println(minO + minX);
        
        sc.close();
    }
}

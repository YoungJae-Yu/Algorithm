import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int L = scanner.nextInt();
        int P = scanner.nextInt();
        int total = L * P;
        
        for (int i = 0; i < 5; i++) {
            int article = scanner.nextInt();
            System.out.print((article - total) + " ");
        }
        
        scanner.close();
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int n = sc.nextInt();
        int calculatedTotal = 0;
        for (int i = 0; i < n; i++) {
            int price = sc.nextInt();
            int quantity = sc.nextInt();
            calculatedTotal += price * quantity;
        }
        if (total == calculatedTotal) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

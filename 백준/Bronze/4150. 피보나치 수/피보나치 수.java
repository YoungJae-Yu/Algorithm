import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        
        if (n == 1) {
            System.out.println(1);
            return;
        }

        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        
        for (int i = 3; i <= n; i++) {
            BigInteger temp = a.add(b);
            a = b;
            b = temp;
        }
        
        System.out.println(b);
    }
}
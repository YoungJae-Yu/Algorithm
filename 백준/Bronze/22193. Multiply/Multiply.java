import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int m = sc.nextInt(); 
        sc.nextLine(); 
        
        BigInteger a = new BigInteger(sc.next());
        BigInteger b = new BigInteger(sc.next());

        System.out.println(a.multiply(b));
    }
}
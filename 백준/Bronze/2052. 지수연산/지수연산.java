import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger pow = BigInteger.valueOf(5).pow(n);
        String s = pow.toString();
        if (s.length() < n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n - s.length(); i++) sb.append('0');
            sb.append(s);
            s = sb.toString();
        }
        System.out.println("0." + s);
    }
}
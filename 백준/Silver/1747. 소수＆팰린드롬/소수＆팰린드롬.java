import java.io.*;

public class Main {
    static boolean isPalindrome(int n) {
        String s = Integer.toString(n);
        return new StringBuilder(s).reverse().toString().equals(s);
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * (long)i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        for (int i = n; ; i++) {
            if (isPalindrome(i) && isPrime(i)) {
                System.out.println(i);
                break;
            }
        }
    }
}
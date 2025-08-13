import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        BigInteger ans = BigInteger.ZERO;
        BigInteger base = BigInteger.valueOf(26);
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'A' + 1;
            ans = ans.multiply(base).add(BigInteger.valueOf(val));
        }
        System.out.println(ans.toString());
    }
}
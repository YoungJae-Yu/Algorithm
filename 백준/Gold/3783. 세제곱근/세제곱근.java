import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        BigInteger TEN = BigInteger.TEN;
        BigInteger SCALE = TEN.pow(30);
        BigInteger DIV = TEN.pow(10);
        for (int t = 0; t < T; t++) {
            String s = br.readLine().trim();
            BigInteger n = new BigInteger(s);
            BigInteger scaled = n.multiply(SCALE);
            int len = scaled.toString().length();
            int k = (len + 2) / 3;
            BigInteger low = BigInteger.ZERO;
            BigInteger high = TEN.pow(k).add(BigInteger.ONE);
            BigInteger two = BigInteger.valueOf(2L);
            while (low.compareTo(high) < 0) {
                BigInteger mid = low.add(high).add(BigInteger.ONE).divide(two);
                BigInteger mid3 = mid.pow(3);
                if (mid3.compareTo(scaled) <= 0) {
                    low = mid;
                } else {
                    high = mid.subtract(BigInteger.ONE);
                }
            }
            BigInteger cr = low;
            BigInteger ip = cr.divide(DIV);
            BigInteger frac = cr.mod(DIV);
            String fracStr = frac.toString();
            if (fracStr.length() < 10) {
                StringBuilder z = new StringBuilder();
                for (int i = 0; i < 10 - fracStr.length(); i++) z.append('0');
                z.append(fracStr);
                fracStr = z.toString();
            }
            sb.append(ip.toString()).append(".").append(fracStr).append("\n");
        }
        System.out.print(sb.toString());
    }
}
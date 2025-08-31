import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            if (N % 2 == 1) sb.append("0\n");
            else sb.append(BigInteger.valueOf(2).pow(N / 2).toString()).append('\n');
        }
        System.out.print(sb.toString());
    }
}
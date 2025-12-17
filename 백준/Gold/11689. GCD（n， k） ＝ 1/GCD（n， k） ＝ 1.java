import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());
        long result = n;
        long temp = n;
        for (long p = 2; p * p <= temp; p++) {
            if (temp % p == 0) {
                while (temp % p == 0) temp /= p;
                result = result - result / p;
            }
        }
        if (temp > 1) result = result - result / temp;
        System.out.println(result);
    }
}
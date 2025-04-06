import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        boolean[] isPrime = new boolean[1_000_001];
        for (int i = 2; i <= 1_000_000; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= 1_000_000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 1_000_000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int[] primes = new int[78498];
        int index = 0;
        for (int i = 2; i <= 1_000_000; i++) {
            if (isPrime[i]) {
                primes[index++] = i;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            long S = Long.parseLong(reader.readLine());
            boolean isValid = true;
            for (int prime : primes) {
                if (prime * (long) prime > S) {
                    break;
                }
                if (S % prime == 0) {
                    isValid = false;
                    break;
                }
            }
            result.append(isValid ? "YES" : "NO").append("\n");
        }
        System.out.print(result);
    }
}
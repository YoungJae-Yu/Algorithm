import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine().trim());
        long ans = 0;
        for (long i = 1; i <= N / i; i++) {
            if (N % i == 0) {
                if (i == N / i) ans += 1;
                else ans += 2;
            }
        }
        System.out.println(ans);
    }
}
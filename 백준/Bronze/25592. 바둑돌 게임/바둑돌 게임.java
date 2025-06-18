import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine().trim());

        // k*(k+1)/2 <= N < (k+1)*(k+2)/2 인 k 찾기
        long k = (long)((Math.sqrt(1 + 8.0 * N) - 1) / 2);
        long t = k + 1;

        if (t % 2 == 0) {
            System.out.print(0);
        } else {
            long boundary = t * (t + 1) / 2;
            System.out.print(boundary - N);
        }
    }
}
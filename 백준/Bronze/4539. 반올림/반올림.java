import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            for (int place = 10; x >= place; place *= 10) {
                int digit = (x % place) / (place / 10);
                if (digit >= 5) {
                    x = (x / place + 1) * place;
                } else {
                    x = (x / place) * place;
                }
            }
            System.out.println(x);
        }
    }
}
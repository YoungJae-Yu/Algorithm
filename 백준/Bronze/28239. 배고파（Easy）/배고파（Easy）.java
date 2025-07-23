import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            long m = Long.parseLong(br.readLine());
            if (Long.bitCount(m) == 1) {
                int p = Long.numberOfTrailingZeros(m);
                sb.append(p - 1).append(' ').append(p - 1).append('\n');
            } else {
                int x = Long.numberOfTrailingZeros(m);
                int y = 63 - Long.numberOfLeadingZeros(m);
                sb.append(x).append(' ').append(y).append('\n');
            }
        }
        System.out.print(sb);
    }
}
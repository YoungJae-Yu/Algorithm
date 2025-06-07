import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = 0;
        int lastParity = -1;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            int parity = num % 2;
            if (count == 0 || parity != lastParity) {
                count++;
                lastParity = parity;
            }
        }
        System.out.print(count);
    }
}
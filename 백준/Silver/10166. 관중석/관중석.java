import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D1 = Integer.parseInt(st.nextToken());
        int D2 = Integer.parseInt(st.nextToken());
        boolean[][] seen = new boolean[D2 + 1][D2 + 1];
        int count = 0;
        for (int r = D1; r <= D2; r++) {
            for (int seat = 1; seat <= r; seat++) {
                int g = gcd(r, seat);
                int a = seat / g;
                int b = r / g;
                if (!seen[a][b]) {
                    seen[a][b] = true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
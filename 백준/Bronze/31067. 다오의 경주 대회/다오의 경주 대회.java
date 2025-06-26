import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        if (n <= 1) {
            System.out.println(0);
            return;
        }

        st = new StringTokenizer(br.readLine());
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        int count = 0;
        long prev = a[0];

        for (int i = 1; i < n; i++) {
            if (a[i] > prev) {
                prev = a[i];
            } else {
                count++;
                long modified = a[i] + k;
                if (modified <= prev) {
                    System.out.println(-1);
                    return;
                }
                prev = modified;
            }
        }

        System.out.println(count);
    }
}

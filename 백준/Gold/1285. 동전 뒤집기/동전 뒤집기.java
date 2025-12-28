import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] a = new String[n];
        for (int i = 0; i < n; i++) a[i] = br.readLine().trim();
        int ans = Integer.MAX_VALUE;
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                int tail = 0;
                for (int i = 0; i < n; i++) {
                    char c = a[i].charAt(j);
                    if (((mask >> i) & 1) == 1) c = (c == 'H') ? 'T' : 'H';
                    if (c == 'T') tail++;
                }
                sum += Math.min(tail, n - tail);
            }
            if (sum < ans) ans = sum;
        }
        System.out.println(ans);
    }
}
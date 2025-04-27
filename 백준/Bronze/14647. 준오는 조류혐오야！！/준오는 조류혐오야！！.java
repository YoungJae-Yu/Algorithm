import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int total9 = 0;
        int[] row9 = new int[n];
        int[] col9 = new int[m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int x = Integer.parseInt(st.nextToken());
                int cnt = 0;
                while (x > 0) {
                    if (x % 10 == 9) cnt++;
                    x /= 10;
                }
                total9 += cnt;
                row9[i] += cnt;
                col9[j] += cnt;
            }
        }
        int max9 = 0;
        for (int v : row9) if (v > max9) max9 = v;
        for (int v : col9) if (v > max9) max9 = v;
        System.out.println(total9 - max9);
    }
}
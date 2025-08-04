import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] p = new int[N+1];
        int[] m = new int[N+1];
        Arrays.fill(p, -1);
        Arrays.fill(m, -1);

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            char b = st.nextToken().charAt(0);
            int c = Integer.parseInt(st.nextToken());
            if (b == 'P') {
                p[a] = c;
            } else {
                m[a] = c;
            }
        }

        int minCount = 0;
        int maxCount = 0;
        for (int i = 1; i <= N; i++) {
            if (p[i] != 0 && m[i] != 1) {
                maxCount++;
                if (p[i] == 1 && m[i] == 0) {
                    minCount++;
                }
            }
        }

        System.out.println(minCount + " " + maxCount);
    }
}
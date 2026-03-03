import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine().trim());
        int[] A = new int[101];
        int[] B = new int[101];
        for (int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a]++;
            B[b]++;
            int[] ta = Arrays.copyOf(A, 101);
            int[] tb = Arrays.copyOf(B, 101);
            int i = 0, j = 100;
            int max = 0;
            while (i <= 100 && j >= 0) {
                while (i <= 100 && ta[i] == 0) i++;
                while (j >= 0 && tb[j] == 0) j--;
                if (i > 100 || j < 0) break;
                int take = Math.min(ta[i], tb[j]);
                max = Math.max(max, i + j);
                ta[i] -= take;
                tb[j] -= take;
            }
            sb.append(max).append('\n');
        }
        System.out.print(sb.toString());
    }
}
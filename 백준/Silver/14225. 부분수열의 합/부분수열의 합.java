import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            sum += a[i];
        }
        boolean[] possible = new boolean[sum + 2];
        int maxMask = 1 << N;
        for (int mask = 0; mask < maxMask; mask++) {
            int s = 0;
            for (int j = 0; j < N; j++) {
                if ((mask & (1 << j)) != 0) s += a[j];
            }
            if (s <= sum + 1) possible[s] = true;
        }
        for (int i = 1; i <= sum + 1; i++) {
            if (!possible[i]) {
                System.out.println(i);
                return;
            }
        }
    }
}
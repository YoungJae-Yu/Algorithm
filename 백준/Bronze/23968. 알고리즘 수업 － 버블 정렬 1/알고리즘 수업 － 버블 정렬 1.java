import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        for (int last = N; last >= 2; last--) {
            for (int i = 0; i < last - 1; i++) {
                if (A[i] > A[i + 1]) {
                    int t = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = t;
                    count++;
                    if (count == K) {
                        int x = Math.min(A[i], A[i + 1]);
                        int y = Math.max(A[i], A[i + 1]);
                        System.out.println(x + " " + y);
                        return;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
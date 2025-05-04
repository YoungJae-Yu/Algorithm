import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int swapCount = 0;
        for (int last = N; last >= 2; last--) {
            int maxIdx = 1;
            for (int i = 2; i <= last; i++) {
                if (A[i] > A[maxIdx]) {
                    maxIdx = i;
                }
            }
            if (maxIdx != last) {
                int tmp = A[last];
                A[last] = A[maxIdx];
                A[maxIdx] = tmp;
                swapCount++;
                if (swapCount == K) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1; i <= N; i++) {
                        sb.append(A[i]).append(' ');
                    }
                    System.out.println(sb.toString().trim());
                    return;
                }
            }
        }

        System.out.println(-1);
    }
}
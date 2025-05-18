import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        long count = 0;
        int result = -1;
        for (int i = 1; i < N; i++) {
            int cur = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > cur) {
                A[j + 1] = A[j];
                count++;
                if (count == K) {
                    result = A[j + 1];
                }
                j--;
            }
            if (j + 1 != i) {
                A[j + 1] = cur;
                count++;
                if (count == K) {
                    result = A[j + 1];
                }
            }
        }
        System.out.print(result);
    }
}
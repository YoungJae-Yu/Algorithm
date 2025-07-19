import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        if (isEqual(A, B)) {
            System.out.println(1);
            return;
        }
        for (int last = N - 1; last >= 1; last--) {
            int maxIdx = 0;
            for (int i = 1; i <= last; i++) {
                if (A[i] > A[maxIdx]) {
                    maxIdx = i;
                }
            }
            if (maxIdx != last) {
                int tmp = A[last];
                A[last] = A[maxIdx];
                A[maxIdx] = tmp;
                if (isEqual(A, B)) {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);
    }

    static boolean isEqual(int[] A, int[] B) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) {
                return false;
            }
        }
        return true;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] A, tmp;
    static long K;
    static long count = 0;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());
        
        A = new int[N + 1];
        tmp = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        mergeSort(1, N);
        
        System.out.println(result);
    }
    
    public static void mergeSort(int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(p, q);
            mergeSort(q + 1, r);
            merge(p, q, r);
        }
    }
    
    public static void merge(int p, int q, int r) {
        int i = p, j = q + 1, t = 1;
        
        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++];
            } else {
                tmp[t++] = A[j++];
            }
            if (++count == K) {
                result = tmp[t - 1];
            }
        }
        
        while (i <= q) {
            tmp[t++] = A[i++];
            if (++count == K) {
                result = tmp[t - 1];
            }
        }
        
        while (j <= r) {
            tmp[t++] = A[j++];
            if (++count == K) {
                result = tmp[t - 1];
            }
        }
        
        i = p; t = 1;
        while (i <= r) {
            A[i++] = tmp[t++];
        }
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] primes = new long[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) primes[i] = Long.parseLong(st.nextToken());
        long[] arr = new long[N + 1];
        int[] idx = new int[K];
        arr[0] = 1;
        for (int i = 1; i <= N; i++) {
            long next = Long.MAX_VALUE;
            for (int j = 0; j < K; j++) {
                long candidate = arr[idx[j]] * primes[j];
                if (candidate < next) next = candidate;
            }
            arr[i] = next;
            for (int j = 0; j < K; j++) {
                if (arr[idx[j]] * primes[j] == next) idx[j]++;
            }
        }
        System.out.println(arr[N]);
    }
}
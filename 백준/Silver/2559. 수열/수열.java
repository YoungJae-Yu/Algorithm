import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] numbers = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += numbers[i];
        }
        
        int maxSum = sum;
        for (int i = K; i < N; i++) {
            sum += numbers[i] - numbers[i - K];
            maxSum = Math.max(maxSum, sum);
        }
        
        System.out.println(maxSum);
    }
}
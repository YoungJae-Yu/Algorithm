import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        
        long left = 1;
        long right = (long) N * N;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            
            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }
            
            if (count < K) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        
        System.out.println(answer);
    }
}
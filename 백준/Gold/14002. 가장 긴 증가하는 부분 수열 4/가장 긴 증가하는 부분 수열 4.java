import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];
        int[] trace = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            dp[i] = 1;
            trace[i] = -1;
        }
        
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    trace[i] = j;
                }
            }
            if (dp[maxIndex] < dp[i]) {
                maxIndex = i;
            }
        }
        
        System.out.println(dp[maxIndex]);
        
        ArrayList<Integer> lis = new ArrayList<>();
        for (int i = maxIndex; i != -1; i = trace[i]) {
            lis.add(0, arr[i]);
        }
        
        for (int num : lis) {
            System.out.print(num + " ");
        }
    }
}
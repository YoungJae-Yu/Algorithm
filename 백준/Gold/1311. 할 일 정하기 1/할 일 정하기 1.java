import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] cost = new int[n][n];
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                cost[i][j] = Integer.parseInt(s[j]);
            }
        }
        
        int size = 1 << n;
        int[] dp = new int[size];
        for(int i = 1; i < size; i++) dp[i] = Integer.MAX_VALUE;
        
        for(int mask = 0; mask < size; mask++) {
            int i = Integer.bitCount(mask);
            if(i >= n) continue;
            for(int j = 0; j < n; j++) {
                if((mask & (1 << j)) == 0) {
                    int nextMask = mask | (1 << j);
                    dp[nextMask] = Math.min(dp[nextMask], dp[mask] + cost[i][j]);
                }
            }
        }
        
        System.out.println(dp[size - 1]);
    }
}
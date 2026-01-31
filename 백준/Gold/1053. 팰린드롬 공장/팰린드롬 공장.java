import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int cost(char[] s){
        int n = s.length;
        int[][] dp = new int[n][n];
        for(int len = 1; len <= n; len++){
            for(int i = 0; i + len - 1 < n; i++){
                int j = i + len - 1;
                if(i == j) {
                    dp[i][j] = 0;
                } else {
                    if(s[i] == s[j]){
                        dp[i][j] = (i+1 <= j-1) ? dp[i+1][j-1] : 0;
                    } else {
                        int a = dp[i+1][j];
                        int b = dp[i][j-1];
                        int c = (i+1 <= j-1) ? dp[i+1][j-1] : 0;
                        dp[i][j] = Math.min(Math.min(a, b), c) + 1;
                    }
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        char[] s = line.toCharArray();
        int n = s.length;
        int ans = cost(s);
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                char tmp = s[i];
                s[i] = s[j];
                s[j] = tmp;
                ans = Math.min(ans, 1 + cost(s));
                tmp = s[i];
                s[i] = s[j];
                s[j] = tmp;
            }
        }
        System.out.println(ans);
    }
}
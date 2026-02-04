import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] A;
    static int[][] gemPS, impPS;
    static HashMap<String,Integer> memo = new HashMap<>();

    static int sum(int[][] ps, int r1, int c1, int r2, int c2){
        if(r1>r2 || c1>c2) return 0;
        return ps[r2][c2] - ps[r1-1][c2] - ps[r2][c1-1] + ps[r1-1][c1-1];
    }

    static int dfs(int r1, int r2, int c1, int c2, int lastDir){
        String key = r1 + "," + r2 + "," + c1 + "," + c2 + "," + lastDir;
        if(memo.containsKey(key)) return memo.get(key);
        int gems = sum(gemPS, r1, c1, r2, c2);
        int imps = sum(impPS, r1, c1, r2, c2);
        if(gems == 0){
            memo.put(key, 0);
            return 0;
        }
        if(gems == 1 && imps == 0){
            memo.put(key, 1);
            return 1;
        }
        if(imps == 0){
            memo.put(key, 0);
            return 0;
        }
        long ways = 0;
        for(int i=r1;i<=r2;i++){
            for(int j=c1;j<=c2;j++){
                if(A[i][j] != 1) continue;
                if(lastDir != 1){
                    int gemsOnRow = sum(gemPS, i, c1, i, c2);
                    if(gemsOnRow == 0){
                        int topG = sum(gemPS, r1, c1, i-1, c2);
                        int bottomG = sum(gemPS, i+1, c1, r2, c2);
                        if(topG > 0 && bottomG > 0){
                            int a = dfs(r1, i-1, c1, c2, 1);
                            int b = dfs(i+1, r2, c1, c2, 1);
                            ways += 1L * a * b;
                        }
                    }
                }
                if(lastDir != 2){
                    int gemsOnCol = sum(gemPS, r1, j, r2, j);
                    if(gemsOnCol == 0){
                        int leftG = sum(gemPS, r1, c1, r2, j-1);
                        int rightG = sum(gemPS, r1, j+1, r2, c2);
                        if(leftG > 0 && rightG > 0){
                            int a = dfs(r1, r2, c1, j-1, 2);
                            int b = dfs(r1, r2, j+1, c2, 2);
                            ways += 1L * a * b;
                        }
                    }
                }
            }
        }
        int ans = (int) ways;
        memo.put(key, ans);
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        A = new int[N+1][N+1];
        gemPS = new int[N+1][N+1];
        impPS = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                gemPS[i][j] = gemPS[i-1][j] + gemPS[i][j-1] - gemPS[i-1][j-1] + (A[i][j]==2 ? 1 : 0);
                impPS[i][j] = impPS[i-1][j] + impPS[i][j-1] - impPS[i-1][j-1] + (A[i][j]==1 ? 1 : 0);
            }
        }
        int res = dfs(1, N, 1, N, 0);
        if(res == 0) System.out.println(-1);
        else System.out.println(res);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int hardCount = 0;
        int easyCount = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (b <= L) {
                hardCount++;
            } else if (a <= L) {
                easyCount++;
            }
        }

        int solveHard = Math.min(hardCount, K);
        int score = solveHard * 140;
        K -= solveHard;

        int solveEasy = Math.min(easyCount, K);
        score += solveEasy * 100;

        System.out.println(score);
    }
}
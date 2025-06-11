import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();
        int H = sc.nextInt();
        int W = sc.nextInt();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < H; i++) {
            int p = sc.nextInt();
            for (int j = 0; j < W; j++) {
                int cap = sc.nextInt();
                if (cap >= N) {
                    int cost = p * N;
                    if (cost <= B && cost < ans) {
                        ans = cost;
                    }
                }
            }
        }
        System.out.println(ans == Integer.MAX_VALUE ? "stay home" : ans);
    }
}
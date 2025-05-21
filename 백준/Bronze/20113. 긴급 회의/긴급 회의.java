import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(st.nextToken());
            if (v > 0) cnt[v - 1]++;
        }
        int max = 0;
        int idx = -1;
        boolean tie = false;
        for (int i = 0; i < n; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                idx = i;
                tie = false;
            } else if (cnt[i] == max) {
                tie = true;
            }
        }
        if (max == 0 || tie) {
            System.out.println("skipped");
        } else {
            System.out.println(idx + 1);
        }
    }
}
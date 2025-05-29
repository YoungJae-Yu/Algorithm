import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N < 2023) {
            System.out.println(0);
            return;
        }
        int ans = 0;
        for (int i = 2023; i <= N; i++) {
            String s = String.valueOf(i);
            int idx = 0;
            char[] target = {'2', '0', '2', '3'};
            for (char c : s.toCharArray()) {
                if (c == target[idx]) {
                    idx++;
                    if (idx == 4) {
                        ans++;
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
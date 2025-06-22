import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            if (Math.abs(S.charAt(i) - S.charAt(i - 1)) == 1) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (cnt == 5) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
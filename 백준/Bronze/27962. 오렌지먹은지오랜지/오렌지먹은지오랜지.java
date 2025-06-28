import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        for (int len = 1; len < n; len++) {
            int diff = 0, start = n - len;
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) != s.charAt(start + i) && ++diff > 1) break;
            }
            if (diff == 1) {
                System.out.print("YES");
                return;
            }
        }
        System.out.print("NO");
    }
}
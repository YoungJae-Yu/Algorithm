import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int cnt = 0, ans = 0;
        for (char c : s.toCharArray()) {
            if ('A' <= c && c <= 'Z') {
                ans += (4 - cnt % 4) % 4;
                cnt = 0;
            }
            cnt++;
        }
        System.out.print(ans);
    }
}
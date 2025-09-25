import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int ans = 0;
        for (int i = 0; i + 2 < M; ) {
            if (s.charAt(i) == 'I') {
                int cnt = 0;
                int j = i;
                while (j + 2 < M && s.charAt(j + 1) == 'O' && s.charAt(j + 2) == 'I') {
                    cnt++;
                    j += 2;
                }
                if (cnt >= N) ans += cnt - N + 1;
                i = (j == i) ? i + 1 : j;
            } else {
                i++;
            }
        }
        System.out.println(ans);
    }
}
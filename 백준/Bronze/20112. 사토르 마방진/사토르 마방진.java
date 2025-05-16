import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] a = new char[N][];
        for (int i = 0; i < N; i++) {
            a[i] = br.readLine().toCharArray();
        }
        boolean ok = true;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (a[i][j] != a[j][i]) {
                    ok = false;
                    break;
                }
            }
            if (!ok) break;
        }
        System.out.print(ok ? "YES" : "NO");
    }
}
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = read();
        int[] arr = new int[n], cnt = new int[4];
        for (int i = 0; i < n; i++) cnt[arr[i] = read()]++;
        int u = read() - cnt[1], d = read() - cnt[2];
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) sb.append('U');
            else if (arr[i] == 2) sb.append('D');
            else {
                if (u > 0) {
                    u--;
                    sb.append('U');
                } else if (d > 0) {
                    d--;
                    sb.append('D');
                } else {
                    sb.append('U');
                }
            }
        }
        if (u == 0 && d == 0) {
            bw.write("YES\n");
            bw.write(sb.toString());
        } else {
            bw.write("NO");
        }
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
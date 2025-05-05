import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int maxN = 80000;
        int[] sum = new int[maxN + 1];

        for (int i = 1; i <= maxN; i++) {
            sum[i] = sum[i - 1];
            if (i % 3 == 0 || i % 7 == 0) {
                sum[i] += i;
            }
        }

        int T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(st.nextToken());
            bw.write(sum[N] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
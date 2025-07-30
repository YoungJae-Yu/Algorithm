import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long totalWeight = 0;
        long totalAppleCount = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String T = st.nextToken();
            if (T.equals("A")) {
                long w = Long.parseLong(st.nextToken());
                long h = Long.parseLong(st.nextToken());
                long l = Long.parseLong(st.nextToken());
                totalAppleCount += (w / 12) * (h / 12) * (l / 12);
                totalWeight += 1000;
            } else {
                totalWeight += 6000;
            }
        }
        totalWeight += totalAppleCount * 500;
        long totalValue = totalAppleCount * 4000;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(totalWeight + "\n");
        bw.write(totalValue + "\n");
        bw.flush();
    }
}
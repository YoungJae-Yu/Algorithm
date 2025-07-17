import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int bestIdx = 1;
        long bestCount = Long.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long j = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            long count = ((j - 1) / (m + 1) + 1) * 2;
            if (count < bestCount) {
                bestCount = count;
                bestIdx = i;
            }
        }
        System.out.println(bestIdx + " " + bestCount);
    }
}
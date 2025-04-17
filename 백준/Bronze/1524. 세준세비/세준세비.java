import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) line = br.readLine();
        if (line == null) return;
        int T = Integer.parseInt(line.trim());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            line = br.readLine();
            while (line != null && line.trim().isEmpty()) line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            line = br.readLine();
            while (line != null && line.trim().isEmpty()) line = br.readLine();
            st = new StringTokenizer(line);
            int maxS = 0;
            for (int i = 0; i < N; i++) {
                maxS = Math.max(maxS, Integer.parseInt(st.nextToken()));
            }
            line = br.readLine();
            while (line != null && line.trim().isEmpty()) line = br.readLine();
            st = new StringTokenizer(line);
            int maxB = 0;
            for (int i = 0; i < M; i++) {
                maxB = Math.max(maxB, Integer.parseInt(st.nextToken()));
            }
            sb.append(maxS >= maxB ? "S" : "B").append('\n');
        }
        System.out.print(sb);
    }
}
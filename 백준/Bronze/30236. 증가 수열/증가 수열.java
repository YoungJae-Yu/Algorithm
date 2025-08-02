import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int current = 1;
            int b = 0;
            for (int i = 0; i < n; i++) {
                int ai = Integer.parseInt(st.nextToken());
                if (ai == current) {
                    b = current + 1;
                    current += 2;
                } else {
                    b = current;
                    current += 1;
                }
            }
            sb.append(b).append('\n');
        }
        System.out.print(sb);
    }
}
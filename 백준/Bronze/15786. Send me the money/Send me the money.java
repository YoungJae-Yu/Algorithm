import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String S = br.readLine();
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            String line = br.readLine();
            int idx = 0;
            for (int i = 0; i < line.length() && idx < N; i++) {
                if (line.charAt(i) == S.charAt(idx)) {
                    idx++;
                }
            }
            sb.append(idx == N ? "true\n" : "false\n");
        }
        System.out.print(sb);
    }
}
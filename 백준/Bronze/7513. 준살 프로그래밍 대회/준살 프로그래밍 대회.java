import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            sb.append("Scenario #").append(t).append(":\n");
            int m = Integer.parseInt(br.readLine());
            String[] words = new String[m];
            for (int i = 0; i < m; i++) {
                words[i] = br.readLine();
            }
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int k = Integer.parseInt(st.nextToken());
                for (int j = 0; j < k; j++) {
                    int idx = Integer.parseInt(st.nextToken());
                    sb.append(words[idx]);
                }
                sb.append("\n");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] before = new String[n];
            String[] after  = new String[n];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                before[i] = st1.nextToken();
            }
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                after[i] = st2.nextToken();
            }
            Arrays.sort(before);
            Arrays.sort(after);
            if (Arrays.equals(before, after)) {
                sb.append("NOT CHEATER\n");
            } else {
                sb.append("CHEATER\n");
            }
        }
        System.out.print(sb);
    }
}
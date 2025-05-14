import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int total = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String time = st.nextToken();
            int duration = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(time.substring(0, 2));
            int M = Integer.parseInt(time.substring(3, 5));
            int start = H * 60 + M;
            for (int j = 0; j < duration; j++) {
                int t = (start + j) % 1440;
                if (t >= 7 * 60 && t < 19 * 60) total += 10;
                else total += 5;
            }
        }
        System.out.println(total);
    }
}
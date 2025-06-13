import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] count = new int[1001];
            int read = 0;

            while (read < N) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                while (read < N && st.hasMoreTokens()) {
                    count[Integer.parseInt(st.nextToken())]++;
                    read++;
                }
            }

            int favorite = 1;
            int maxCount = count[1];

            for (int num = 2; num <= 1000; num++) {
                if (count[num] > maxCount) {
                    maxCount = count[num];
                    favorite = num;
                }
            }

            sb.append(favorite).append('\n');
        }

        System.out.print(sb);
    }
}
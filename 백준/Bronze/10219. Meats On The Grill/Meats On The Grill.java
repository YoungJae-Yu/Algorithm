import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] hw = br.readLine().split(" ");
            int H = Integer.parseInt(hw[0]);
            int W = Integer.parseInt(hw[1]);
            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                StringBuilder sb = new StringBuilder(line);
                System.out.println(sb.reverse().toString());
            }
        }
    }
}
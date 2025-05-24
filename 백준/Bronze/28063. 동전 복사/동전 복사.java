import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] parts = br.readLine().split(" ");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);

        int answer;
        if (N == 1) {
            answer = 0;
        } else {
            answer = 4
                   - ( (x == 1 ? 1 : 0)
                     + (x == N ? 1 : 0)
                     + (y == 1 ? 1 : 0)
                     + (y == N ? 1 : 0) );
        }

        System.out.print(answer);
    }
}
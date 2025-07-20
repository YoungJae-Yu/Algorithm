import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] field = new int[N];
        for (int i = 0; i < N; i++) {
            field[i] = Integer.parseInt(st.nextToken());
        }
        int Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken()) - 1;
            int R = Integer.parseInt(st.nextToken()) - 1;
            if (type == 1) {
                int K = Integer.parseInt(st.nextToken());
                int count = 0;
                for (int i = L; i <= R; i++) {
                    if (field[i] == K) {
                        count++;
                    }
                }
                bw.write(count + "\n");
            } else {
                for (int i = L; i <= R; i++) {
                    field[i] = 0;
                }
            }
        }
        bw.flush();
    }
}
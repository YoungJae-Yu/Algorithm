import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 수의 개수 N
        int[] counts = new int[10001]; // 0부터 10,000까지의 수를 카운트할 배열

        // 입력받은 수 카운트
        for (int i = 0; i < N; i++) {
            counts[Integer.parseInt(br.readLine())]++;
        }

        // 카운트된 수대로 출력
        for (int i = 1; i < 10001; i++) {
            for (int j = 0; j < counts[i]; j++) {
                bw.write(i + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}

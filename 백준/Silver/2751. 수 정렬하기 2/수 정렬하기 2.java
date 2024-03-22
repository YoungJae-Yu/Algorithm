import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 수의 개수 N을 입력받음
        int[] numbers = new int[N]; // 입력받을 수를 저장할 배열

        // N개의 수 입력받기
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        // 배열 오름차순으로 정렬
        Arrays.sort(numbers);

        // 정렬된 수 출력
        for (int num : numbers) {
            bw.write(num + "\n");
        }

        // 자원 해제
        br.close();
        bw.flush(); // 남아있는 데이터 모두 출력
        bw.close(); // BufferedWriter 종료
    }
}

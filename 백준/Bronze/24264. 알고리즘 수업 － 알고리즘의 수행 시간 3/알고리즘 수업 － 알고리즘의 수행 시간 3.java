import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력된 n을 정수로 변환
        int n = Integer.parseInt(br.readLine());

        // 코드1의 수행 횟수는 n^2
        long executionCount = (long) n * n;

        // 출력
        System.out.println(executionCount); // 코드1의 수행 횟수 출력
        System.out.println(2); // 최고차항의 차수 출력
    }
}

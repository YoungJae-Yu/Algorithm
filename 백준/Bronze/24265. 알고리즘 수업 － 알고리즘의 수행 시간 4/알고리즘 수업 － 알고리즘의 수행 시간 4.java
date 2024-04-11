import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        // 코드1의 수행 횟수 계산
        long executionCount = n * (n - 1) / 2;

        System.out.println(executionCount); // 수행 횟수 출력
        System.out.println(2); // 최고차항의 차수 출력
    }
}

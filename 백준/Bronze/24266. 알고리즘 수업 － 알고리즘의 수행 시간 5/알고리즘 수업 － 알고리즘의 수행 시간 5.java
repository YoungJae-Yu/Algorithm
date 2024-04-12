import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine()); // 입력 받기

        // 코드1의 수행 횟수 출력
        System.out.println(n * n * n); // n^3 계산하여 출력

        // 최고차항의 차수 출력
        System.out.println(3); // 이 문제에서는 항상 3
    }
}

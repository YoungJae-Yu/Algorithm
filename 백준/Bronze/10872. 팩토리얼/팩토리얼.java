import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    
    // 팩토리얼을 계산하는 재귀 함수
    public static int factorial(int n) {
        if (n <= 1) return 1; // 0!과 1! 은 1로 정의됩니다.
        else return n * factorial(n-1);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력을 받아 정수로 변환
        int N = Integer.parseInt(br.readLine());
        
        // 팩토리얼 계산 결과 출력
        System.out.println(factorial(N));
    }
}

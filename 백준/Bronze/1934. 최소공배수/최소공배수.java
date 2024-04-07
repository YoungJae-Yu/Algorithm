import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
        
        for(int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            
            int gcd = gcd(A, B); // A와 B의 최대공약수
            
            // 최소공배수 = A * B / 최대공약수
            int lcm = A * B / gcd;
            System.out.println(lcm);
        }
    }
    
    // 유클리드 호제법을 이용한 최대공약수 계산 메소드
    public static int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b; // 나머지를 구함
            // GCD(a, b) = GCD(b, r) 공식을 이용
            a = b;
            b = r;
        }
        return a;
    }
}

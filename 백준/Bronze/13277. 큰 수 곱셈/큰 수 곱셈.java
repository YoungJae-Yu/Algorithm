import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력받은 두 큰 수
        BigInteger A = new BigInteger(sc.next());
        BigInteger B = new BigInteger(sc.next());
        
        // 곱셈 결과 출력
        System.out.println(A.multiply(B));
    }
}
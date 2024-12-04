import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 입력 받기
        BigInteger total = new BigInteger(scanner.nextLine());
        BigInteger difference = new BigInteger(scanner.nextLine());
        
        // 계산
        BigInteger klaudia = total.add(difference).divide(BigInteger.TWO);
        BigInteger natalia = total.subtract(difference).divide(BigInteger.TWO);
        
        // 결과 출력
        System.out.println(klaudia);
        System.out.println(natalia);
    }
}
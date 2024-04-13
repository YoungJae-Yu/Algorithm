import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        long n = scanner.nextLong(); // 입력 받기
        
        // 코드1의 수행 횟수 계산
        long executionCount = n * (n - 1) * (n - 2) / 6;
        
        // 코드1의 수행 횟수 출력
        System.out.println(executionCount);
        
        // 코드1의 수행 횟수의 최고차항의 차수 출력
        System.out.println(3); // 이 경우, 최고차항의 차수는 항상 3
    }
}

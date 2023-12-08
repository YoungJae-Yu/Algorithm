import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt(); // 테스트 케이스의 개수
        
        for (int i = 0; i < T; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            
            // 데이터의 번호에 대응하는 컴퓨터 번호 계산
            int computerNumber = (int) Math.pow(a % 10, b % 4 + 4); // b % 4 + 4는 사이클을 이루는 값의 범위
            computerNumber %= 10; // 10으로 나눈 나머지가 컴퓨터 번호
            
            // 0일 경우 10으로 출력
            if (computerNumber == 0) {
                computerNumber = 10;
            }
            
            System.out.println(computerNumber);
        }
    }
}

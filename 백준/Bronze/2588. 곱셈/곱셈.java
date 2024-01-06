import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt(); // 첫 번째 숫자 입력
        int num2 = scanner.nextInt(); // 두 번째 숫자 입력

        int result1 = num1 * (num2 % 10); // 3번째 줄 값
        int result2 = num1 * ((num2 / 10) % 10); // 4번째 줄 값
        int result3 = num1 * (num2 / 100); // 5번째 줄 값
        int totalResult = num1 * num2; // 6번째 줄 값

        // 결과 출력
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(totalResult);

        scanner.close(); // Scanner 닫기
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int a1 = scanner.nextInt(); // n의 계수
        int a0 = scanner.nextInt(); // 상수 항
        int c = scanner.nextInt();  // c 값
        int n0 = scanner.nextInt(); // n0 값

        // O(n) 정의를 만족하는지 확인하는 변수
        boolean isSatisfy = true;

        // n0부터 시작하여 O(n) 정의를 만족하는지 확인
        for (int n = n0; n <= 100; n++) {
            if (a1 * n + a0 > c * n) {
                isSatisfy = false;
                break;
            }
        }

        // 결과 출력
        System.out.println(isSatisfy ? 1 : 0);
    }
}

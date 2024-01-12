import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 테스트 케이스 개수 입력
        int T = scanner.nextInt();

        // 각 테스트 케이스에 대해 처리
        for (int i = 0; i < T; i++) {
            // 두 정수 A와 B 입력
            int A = scanner.nextInt();
            int B = scanner.nextInt();

            // A+B 출력
            System.out.println(A + B);
        }
    }
}

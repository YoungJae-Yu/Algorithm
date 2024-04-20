import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 창문의 개수 N 입력 받음
        int N = scanner.nextInt();

        // N의 제곱근을 구하고, 그 정수 부분을 결과로 출력
        int result = (int)Math.sqrt(N);
        System.out.println(result);
    }
}

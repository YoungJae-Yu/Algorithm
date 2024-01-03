import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 두 개의 자연수 A와 B를 입력받음
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        // A + B
        System.out.println(A + B);
        // A - B
        System.out.println(A - B);
        // A * B
        System.out.println(A * B);
        // A / B
        System.out.println(A / B);
        // A % B
        System.out.println(A % B);

        // 스캐너 닫기
        scanner.close();
    }
}

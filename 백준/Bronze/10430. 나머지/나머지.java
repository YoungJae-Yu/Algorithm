import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // A, B, C 입력 받기
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        // (A+B)%C, ((A%C) + (B%C))%C 계산하여 출력
        System.out.println((A + B) % C);
        System.out.println(((A % C) + (B % C)) % C);

        // (A*B)%C, ((A%C) * (B%C))%C 계산하여 출력
        System.out.println((A * B) % C);
        System.out.println(((A % C) * (B % C)) % C);

        // 스캐너 닫기
        scanner.close();
    }
}

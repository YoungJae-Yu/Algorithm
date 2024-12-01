import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n12 = sc.nextInt();

        // 계산식
        int result = (n1 + 1) * (n2 + 1) / (n12 + 1) - 1;

        // 결과 출력
        System.out.println(result);

        sc.close();
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();

        // 나눗셈 결과를 실수로 표현하기 위해 double로 형변환
        double result = (double) A / B;

        System.out.println(result);
    }
}

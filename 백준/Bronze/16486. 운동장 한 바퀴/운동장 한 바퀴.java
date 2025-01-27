import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double d1 = sc.nextDouble(); // 직사각형 운동장의 가로 길이
        double d2 = sc.nextDouble(); // 원형 반지름

        double perimeter = 2 * d1 + 2 * Math.PI * d2; // 총 둘레 계산
        System.out.println(perimeter);

        sc.close();
    }
}
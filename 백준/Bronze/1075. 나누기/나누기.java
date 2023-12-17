import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int F = sc.nextInt();

        int remainder = N % 100; // N을 100으로 나눈 나머지를 구함

        // F로 나누어 떨어지도록 뒤 두 자리를 조절하여 출력
        int answer = (N / 100) * 100; // 현재의 N의 가장 뒤 두 자리를 00으로 초기화

        for (int i = 0; i < 100; i++) {
            if ((answer + i) % F == 0) {
                if (i < 10) {
                    System.out.println("0" + i);
                } else {
                    System.out.println(i);
                }
                break;
            }
        }
    }
}

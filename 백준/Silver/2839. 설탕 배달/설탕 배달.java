import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 설탕의 무게 입력
        int bags = 0; // 필요한 봉지의 개수

        while (true) {
            if (N % 5 == 0) { // 5로 나누어 떨어지는 경우
                bags += N / 5; // 5kg 봉지로만 배달 가능
                System.out.println(bags);
                break;
            } else if (N <= 0) { // 정확하게 Nkg을 만들 수 없는 경우
                System.out.println(-1);
                break;
            }
            N -= 3; // 5kg 봉지로 나누어 떨어지지 않으면 3kg를 빼고 계산
            bags++; // 3kg 봉지를 하나 추가
        }

        scanner.close();
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 상금 입력 받기
        int N = scanner.nextInt();

        // 첫 번째 경우: 전체 상금에서 22% 세금을 냄
        int case1 = (int) (N * 0.78);

        // 두 번째 경우: 80%는 비과세, 나머지 20%에 대해서만 22% 세금을 냄
        int case2 = (int) (N * 0.956);

        // 결과 출력
        System.out.println(case1 + " " + case2);

        scanner.close();
    }
}
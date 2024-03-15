import java.util.Scanner;

public class Main {
    // 분해합을 계산하는 함수
    public static int calculateDecompositionSum(int number) {
        int sum = number;
        while (number > 0) {
            sum += number % 10; // 각 자리수를 더함
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 자연수 N 입력 받음
        int result = 0;

        // 1부터 N까지 모든 수에 대해 분해합을 계산
        for (int i = 1; i < N; i++) {
            if (calculateDecompositionSum(i) == N) {
                result = i;
                break; // 가장 작은 생성자를 찾으면 반복 종료
            }
        }

        System.out.println(result); // 결과 출력
        scanner.close();
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 수의 개수 입력
        int[] numbers = new int[N]; // 수를 저장할 배열 생성

        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt(); // 수 입력
        }

        Arrays.sort(numbers); // 배열 오름차순 정렬

        for (int number : numbers) {
            System.out.println(number); // 정렬된 수 출력
        }

        scanner.close();
    }
}

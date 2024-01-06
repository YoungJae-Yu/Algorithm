import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        String input = scanner.nextLine();
        String[] numbers = input.split(" "); // 공백을 기준으로 문자열 나누기

        // 문자열을 정수로 변환하여 더하기
        long sum = 0;
        for (String number : numbers) {
            sum += Long.parseLong(number);
        }

        // 결과 출력
        System.out.println(sum);

        scanner.close();
    }
}

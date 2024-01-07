import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); // 입력 받기

        String[] numbers = input.split(" "); // 공백을 기준으로 문자열 나누기

        int A = Integer.parseInt(numbers[0]); // 첫 번째 숫자로 변환
        int B = Integer.parseInt(numbers[1]); // 두 번째 숫자로 변환

        if (A > B) {
            System.out.println(">");
        } else if (A < B) {
            System.out.println("<");
        } else {
            System.out.println("==");
        }
    }
}

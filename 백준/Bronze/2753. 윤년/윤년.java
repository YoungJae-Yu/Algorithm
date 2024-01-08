import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt(); // 연도 입력 받기

        // 조건에 맞는지 확인하여 출력
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println(1); // 윤년인 경우
        } else {
            System.out.println(0); // 윤년이 아닌 경우
        }
    }
}

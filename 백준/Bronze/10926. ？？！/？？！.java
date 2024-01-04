import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 아이디 입력 받기
        String username = scanner.nextLine();

        // 아이디에 ??!를 붙여 출력
        System.out.println(username + "??!");

        // 스캐너 닫기
        scanner.close();
    }
}

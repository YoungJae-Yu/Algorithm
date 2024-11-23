import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 테스트 케이스 개수 입력
        sc.nextLine(); // 개행 문자 제거

        for (int i = 0; i < n; i++) {
            String password = sc.nextLine();
            if (password.length() >= 6 && password.length() <= 9) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

        sc.close();
    }
}
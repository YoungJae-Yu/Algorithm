import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 녹색거탑의 높이 N을 입력받는다.
        int N = scanner.nextInt();

        // 경우의 수를 계산하여 출력한다. 2^N을 계산.
        System.out.println((int) Math.pow(2, N));
    }
}

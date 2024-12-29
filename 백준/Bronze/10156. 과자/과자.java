import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt(); // 과자 한 개의 가격
        int N = sc.nextInt(); // 사려고 하는 과자의 개수
        int M = sc.nextInt(); // 현재 가진 돈

        int totalCost = K * N; // 과자를 사기 위해 필요한 총 금액
        int result = totalCost > M ? totalCost - M : 0; // 부족한 금액 계산

        System.out.println(result);
    }
}
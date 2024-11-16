import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력받기
        int n1 = sc.nextInt(); // 첫 번째 비행기의 좌석 행 수
        int k1 = sc.nextInt(); // 첫 번째 비행기의 한 행의 좌석 수
        int n2 = sc.nextInt(); // 두 번째 비행기의 좌석 행 수
        int k2 = sc.nextInt(); // 두 번째 비행기의 한 행의 좌석 수

        // 전체 좌석 수 계산
        int totalSeats = (n1 * k1) + (n2 * k2);

        // 결과 출력
        System.out.println(totalSeats);

        sc.close();
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력받기
        int UR = sc.nextInt(); // UR 대학의 참가자 수
        int TR = sc.nextInt(); // TR 대학의 참가자 수
        int UO = sc.nextInt(); // UO 대학의 참가자 수
        int TO = sc.nextInt(); // TO 대학의 참가자 수

        // 각 대학의 점수 계산
        int score = 56 * UR + 24 * TR + 14 * UO + 6 * TO;

        // 결과 출력
        System.out.println(score);

        sc.close();
    }
}
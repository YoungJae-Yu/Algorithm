import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 현재 시각 입력
        int currentHour = scanner.nextInt();
        int currentMinute = scanner.nextInt();

        // 요리 시간 입력
        int cookingTime = scanner.nextInt();

        // 총 소요 시간 계산
        int totalMinutes = currentHour * 60 + currentMinute + cookingTime;

        // 시간과 분 계산
        int resultHour = (totalMinutes / 60) % 24;
        int resultMinute = totalMinutes % 60;

        System.out.println(resultHour + " " + resultMinute);
    }
}

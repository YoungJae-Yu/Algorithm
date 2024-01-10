import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" "); // 공백을 기준으로 입력값 분리

        int h = Integer.parseInt(input[0]); // 시간
        int m = Integer.parseInt(input[1]); // 분

        int totalMinutes = h * 60 + m; // 입력된 시간을 분 단위로 변환
        int modifiedTime = totalMinutes - 45; // 45분을 뺀다

        // 음수가 되지 않도록 조건 처리
        if (modifiedTime < 0) {
            modifiedTime += 24 * 60; // 음수일 경우 하루를 더해준다
        }

        int resultHour = modifiedTime / 60; // 시간으로 변환
        int resultMinute = modifiedTime % 60; // 분으로 변환

        System.out.println(resultHour + " " + resultMinute); // 결과 출력
    }
}

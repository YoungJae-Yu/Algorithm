import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine(); // 줄바꿈 문자 처리

        int min = 1000001;
        int max = -1000001;

        String[] strNumbers = scanner.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(strNumbers[i]);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        System.out.println(min + " " + max);
    }
}

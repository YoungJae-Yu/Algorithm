import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = sc.nextInt();
        }

        // 세 숫자 중 두 번째로 큰 숫자를 찾음
        int max = Math.max(numbers[0], Math.max(numbers[1], numbers[2]));
        int min = Math.min(numbers[0], Math.min(numbers[1], numbers[2]));
        int second = 0;

        for (int num : numbers) {
            if (num != max && num != min) {
                second = num;
                break;
            }
        }

        System.out.println(second);
    }
}
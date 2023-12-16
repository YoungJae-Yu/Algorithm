import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] divisors = new int[count];

        for (int i = 0; i < count; i++) {
            divisors[i] = sc.nextInt();
        }

        Arrays.sort(divisors); // 약수들을 정렬
        int result = divisors[0] * divisors[count - 1]; // 가장 작은 값과 가장 큰 값을 곱함
        System.out.println(result);
    }
}

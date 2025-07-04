import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int H = sc.nextInt();
        int[] rating = new int[N];
        for (int i = 0; i < N; i++) {
            rating[i] = sc.nextInt();
        }
        Arrays.sort(rating);
        long sum = 0;
        for (int i = L; i < N - H; i++) {
            sum += rating[i];
        }
        System.out.println(sum / (double)(N - L - H));
    }
}
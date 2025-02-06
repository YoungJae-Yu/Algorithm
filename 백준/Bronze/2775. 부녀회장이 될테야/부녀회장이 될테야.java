import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = j + 1;
            }
            for (int floor = 0; floor < k; floor++) {
                for (int j = 1; j < n; j++) {
                    arr[j] += arr[j - 1];
                }
            }
            System.out.println(arr[n - 1]);
        }
    }
}
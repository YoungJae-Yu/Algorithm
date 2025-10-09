import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[1001];
        int maxIdx = 0;
        int maxH = 0;
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int height = sc.nextInt();
            h[l] = height;
            if (height > maxH) {
                maxH = height;
                maxIdx = l;
            }
        }
        int area = 0;
        int cur = 0;
        for (int i = 0; i <= maxIdx; i++) {
            if (h[i] > cur) cur = h[i];
            area += cur;
        }
        cur = 0;
        for (int i = 1000; i > maxIdx; i--) {
            if (h[i] > cur) cur = h[i];
            area += cur;
        }
        System.out.println(area);
    }
}
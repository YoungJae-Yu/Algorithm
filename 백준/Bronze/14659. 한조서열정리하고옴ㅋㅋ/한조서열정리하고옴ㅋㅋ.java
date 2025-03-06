import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        int maxKill = 0;
        int currentKill = 0;
        int highest = heights[0];

        for (int i = 1; i < n; i++) {
            if (heights[i] < highest) {
                currentKill++;
            } else {
                maxKill = Math.max(maxKill, currentKill);
                highest = heights[i];
                currentKill = 0;
            }
        }
        maxKill = Math.max(maxKill, currentKill);

        System.out.println(maxKill);
    }
}
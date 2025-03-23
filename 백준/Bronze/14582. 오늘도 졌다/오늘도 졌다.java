import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] team1 = new int[9];
        int[] team2 = new int[9];

        for (int i = 0; i < 9; i++) {
            team1[i] = sc.nextInt();
        }
        for (int i = 0; i < 9; i++) {
            team2[i] = sc.nextInt();
        }
        sc.close();

        int sum1 = 0, sum2 = 0;
        boolean lead = false;

        for (int i = 0; i < 9; i++) {
            sum1 += team1[i];
            if (sum1 > sum2) {
                lead = true;
            }
            sum2 += team2[i];
        }

        System.out.println(lead ? "Yes" : "No");
    }
}
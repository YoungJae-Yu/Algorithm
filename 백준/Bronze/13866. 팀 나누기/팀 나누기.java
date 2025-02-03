import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] skills = new int[4];

        for (int i = 0; i < 4; i++) {
            skills[i] = sc.nextInt();
        }

        int team1 = skills[0] + skills[3]; // (A, D)
        int team2 = skills[1] + skills[2]; // (B, C)

        System.out.println(Math.abs(team1 - team2));
    }
}
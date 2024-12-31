import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalScore = 0;

        for (int i = 0; i < 5; i++) {
            int score = sc.nextInt();
            totalScore += Math.max(score, 40);
        }

        System.out.println(totalScore / 5);
    }
}
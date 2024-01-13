import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] dice = new int[3];
        for (int i = 0; i < 3; i++) {
            dice[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(dice);

        int prize;
        if (dice[0] == dice[1] && dice[1] == dice[2]) {
            prize = 10000 + dice[0] * 1000;
        } else if (dice[0] == dice[1] || dice[1] == dice[2]) {
            prize = 1000 + dice[1] * 100;
        } else {
            prize = dice[2] * 100;
        }
        System.out.println(prize);
    }
}

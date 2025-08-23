import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 0, y = 0;
        int rem = n;
        int step = 1;
        int dir = 0;
        int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
        while (rem > 0) {
            for (int t = 0; t < 2 && rem > 0; t++) {
                int dx = d[dir % 4][0];
                int dy = d[dir % 4][1];
                int move = Math.min(step, rem);
                x += dx * move;
                y += dy * move;
                rem -= move;
                dir = (dir + 1) % 4;
            }
            step++;
        }
        System.out.println(x + " " + y);
    }
}
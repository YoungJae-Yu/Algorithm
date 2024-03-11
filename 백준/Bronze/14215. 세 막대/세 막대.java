import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] sides = new int[3];
        for (int i = 0; i < 3; i++) {
            sides[i] = sc.nextInt();
        }

        Arrays.sort(sides);

       if (sides[2] >= sides[0] + sides[1]) {
           sides[2] = sides[0] + sides[1] - 1;
        }
        
        System.out.println(sides[0] + sides[1] + sides[2]);

        sc.close();
    }
}

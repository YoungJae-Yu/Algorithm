import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int minBurger = Integer.MAX_VALUE;
        int minDrink = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            int price = sc.nextInt();
            if (price < minBurger) {
                minBurger = price;
            }
        }

        for (int i = 0; i < 2; i++) {
            int price = sc.nextInt();
            if (price < minDrink) {
                minDrink = price;
            }
        }

        System.out.println(minBurger + minDrink - 50);
    }
}
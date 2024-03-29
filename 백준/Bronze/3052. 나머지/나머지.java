import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashSet<Integer> remainderSet = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            int number = scanner.nextInt();
            remainderSet.add(number % 42);
        }

        System.out.println(remainderSet.size());
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentYear = scanner.nextInt();
        System.out.println(currentYear - 1946);
        scanner.close();
    }
}
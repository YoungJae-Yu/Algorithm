import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String pattern = "WelcomeToSMUPC";
        int index = (N - 1) % pattern.length();
        System.out.println(pattern.charAt(index));
    }
}
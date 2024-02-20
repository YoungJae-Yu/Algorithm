import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.next();
        int B = scanner.nextInt();
        scanner.close();
        
        long result = 0;
        for (int i = 0; i < N.length(); i++) {
            int digit = Character.isDigit(N.charAt(i)) ? N.charAt(i) - '0' : N.charAt(i) - 'A' + 10;
            result = result * B + digit;
        }
        
        System.out.println(result);
    }
}

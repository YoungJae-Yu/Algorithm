import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = sc.next();
        sc.close();

        int result = 1;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'c') {
                result *= (i > 0 && pattern.charAt(i - 1) == 'c') ? 25 : 26;
            } else {
                result *= (i > 0 && pattern.charAt(i - 1) == 'd') ? 9 : 10;
            }
        }

        System.out.println(result);
    }
}
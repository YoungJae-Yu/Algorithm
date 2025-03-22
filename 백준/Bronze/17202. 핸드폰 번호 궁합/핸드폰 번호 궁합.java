import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        sc.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(A.charAt(i)).append(B.charAt(i));
        }

        String result = sb.toString();
        while (result.length() > 2) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < result.length() - 1; i++) {
                int sum = (result.charAt(i) - '0') + (result.charAt(i + 1) - '0');
                temp.append(sum % 10);
            }
            result = temp.toString();
        }

        System.out.println(result);
    }
}
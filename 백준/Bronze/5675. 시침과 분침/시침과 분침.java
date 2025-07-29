import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextInt()) {
            int A = sc.nextInt();
            sb.append(A % 6 == 0 ? 'Y' : 'N').append('\n');
        }
        System.out.print(sb);
        sc.close();
    }
}
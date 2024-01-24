import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String[] strNumbers = scanner.nextLine().split(" ");
        
        int N = Integer.parseInt(input[0]);
        int X =  Integer.parseInt(input[1]);

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(strNumbers[i]);
            if (num < X) {
                System.out.print(num + " ");
            }
        }
    }
}

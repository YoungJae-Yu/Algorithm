import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        int sum = 0;
        int currentNumber = 1;
        int count = 0;

        for (int i = 1; i <= B; i++) {
            if (i >= A) {
                sum += currentNumber;
            }
            count++;
            if (count == currentNumber) {
                currentNumber++;
                count = 0;
            }
        }

        System.out.println(sum);
    }
}
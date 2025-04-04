import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String binaryString = Integer.toBinaryString(n);
        String reversedBinaryString = new StringBuilder(binaryString).reverse().toString();
        int result = Integer.parseInt(reversedBinaryString, 2);
        System.out.println(result);
    }
}
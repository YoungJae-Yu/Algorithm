import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n > 0) {
            System.out.println(Integer.toBinaryString(n).length());
        } else if (n < 0) {
            System.out.println(32);
        } else {
            System.out.println(1);
        }
    }
}
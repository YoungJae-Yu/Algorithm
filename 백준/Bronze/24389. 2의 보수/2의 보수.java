import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int comp = ~n + 1;
        System.out.print(Integer.bitCount(n ^ comp));
    }
}
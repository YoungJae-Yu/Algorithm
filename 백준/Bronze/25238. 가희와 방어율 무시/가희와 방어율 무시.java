import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        long effectiveDefense = (long) a * (100 - b);
        System.out.println(effectiveDefense < 10000 ? 1 : 0);
    }
}
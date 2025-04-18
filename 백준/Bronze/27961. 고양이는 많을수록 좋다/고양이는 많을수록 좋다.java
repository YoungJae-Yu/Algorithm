import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long cats = 0;
        int ops = 0;
        while (cats < N) {
            if (cats == 0) cats = 1;
            else           cats <<= 1;
            ops++;
        }
        System.out.println(ops);
    }
}
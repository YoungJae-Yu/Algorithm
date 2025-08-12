import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long suma = 0;
        long sumb = 0;
        for (int i = 0; i < N; i++) suma += sc.nextInt();
        for (int i = 0; i < N; i++) sumb += sc.nextInt();
        System.out.println(sumb + " " + suma);
        sc.close();
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        
        int place = 10;
        while (N >= place) {
            N = (N + place / 2) / place * place;
            place *= 10;
        }

        System.out.println(N);
    }
}
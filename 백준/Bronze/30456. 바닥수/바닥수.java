import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < L - 1; i++) {
            sb.append('1');
        }
        sb.append(N);
        System.out.println(sb);
    }
}
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String s = sc.next();
        int train = 1;
        boolean lever = false;
        int answer = 5;
        for (int i = 0; i < N; i++) {
            if (train == 3) break;
            char c = s.charAt(i);
            if (c == 'W') {
                train++;
            } else { // 'P'
                if (train == 1) {
                    answer = lever ? 5 : 1;
                    lever = !lever;
                } else if (train == 2) {
                    answer = 6;
                }
            }
        }
        if (train < 3) answer = 0;
        System.out.println(answer);
    }
}
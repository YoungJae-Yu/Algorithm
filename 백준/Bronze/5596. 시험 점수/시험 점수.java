import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 민수의 점수 합계
        int minguk = 0;
        for (int i = 0; i < 4; i++) {
            minguk += sc.nextInt();
        }

        // 만세의 점수 합계
        int mansae = 0;
        for (int i = 0; i < 4; i++) {
            mansae += sc.nextInt();
        }

        // 더 높은 점수 출력
        System.out.println(Math.max(minguk, mansae));
    }
}
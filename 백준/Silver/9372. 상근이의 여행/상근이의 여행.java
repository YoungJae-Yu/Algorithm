import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt(); // 국가의 수
            int M = sc.nextInt(); // 비행기의 수
            
            // 비행기 정보는 입력받지만 사실상 사용하지 않습니다.
            for (int j = 0; j < M; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
            }
            
            // 국가의 수 - 1이 정답
            System.out.println(N - 1);
        }

        sc.close();
    }
}
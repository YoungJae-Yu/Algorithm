import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수
        
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt(); // 시작 숫자
            int M = sc.nextInt(); // 끝 숫자
            
            int count = 0;
            // N부터 M까지 각 숫자를 문자열로 변환하여 0의 개수 세기
            for (int i = N; i <= M; i++) {
                String numStr = String.valueOf(i);
                for (char c : numStr.toCharArray()) {
                    if (c == '0') {
                        count++;
                    }
                }
            }
            
            System.out.println(count);
        }
        
        sc.close();
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        // 상의와 하의가 서로 다른 색상인 조합의 가짓수 계산
        int result = N * (N - 1);
        
        System.out.println(result);
    }
}

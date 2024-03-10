import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            
            // 입력 종료 조건
            if(a == 0 && b == 0 && c == 0) break;
            
            // 변 길이 정렬
            int max = Math.max(a, Math.max(b, c));
            int sum = a + b + c - max;
            
            // 삼각형 유효성 검사
            if(max >= sum) {
                System.out.println("Invalid");
            } else {
                // 삼각형 타입 판별
                if(a == b && b == c) {
                    System.out.println("Equilateral");
                } else if(a == b || b == c || a == c) {
                    System.out.println("Isosceles");
                } else {
                    System.out.println("Scalene");
                }
            }
        }
    }
}

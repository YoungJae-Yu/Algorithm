import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 정수로 입력 받기
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        // 첫 번째 출력: 수로 간주하여 계산
        System.out.println(A + B - C);
        
        // 두 번째 출력: 문자열로 간주하여 계산
        String strA = String.valueOf(A);
        String strB = String.valueOf(B);
        String concatenated = strA + strB;
        int concatenatedValue = Integer.parseInt(concatenated);
        System.out.println(concatenatedValue - C);
        
        sc.close();
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 문자열의 길이 N 입력
        sc.nextLine(); // 개행 문자 처리
        String S = sc.nextLine(); // 문자열 S 입력
        
        // 문자열 S의 마지막 5글자 출력
        System.out.println(S.substring(S.length() - 5));
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        
        // 절댓값 차이 계산
        System.out.println(Math.abs(n - m));
    }
}
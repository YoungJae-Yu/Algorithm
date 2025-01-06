import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt(); // 시
        int B = sc.nextInt(); // 분
        int C = sc.nextInt(); // 초
        int D = sc.nextInt(); // 추가할 초
        
        // 현재 시간을 초 단위로 변환
        int totalSeconds = A * 3600 + B * 60 + C + D;
        
        // 초를 시, 분, 초로 변환
        A = (totalSeconds / 3600) % 24;
        B = (totalSeconds % 3600) / 60;
        C = totalSeconds % 60;
        
        System.out.println(A + " " + B + " " + C);
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 세 점의 좌표 입력
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();
        
        // CCW 계산
        int ccw = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
        
        // 방향 출력
        if (ccw > 0) {
            System.out.println(1);  // 반시계 방향
        } else if (ccw < 0) {
            System.out.println(-1); // 시계 방향
        } else {
            System.out.println(0);  // 일직선
        }
        
        sc.close();
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt(); // 테스트 케이스의 개수
        
        for (int i = 0; i < T; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int r1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int r2 = scanner.nextInt();
            
            // 두 터렛 사이의 거리
            double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            
            // 두 터렛과 적까지의 거리
            double d1 = Math.abs(r2 - r1);
            double d2 = Math.abs(r2 + r1);
            
            // 무한대의 위치인 경우
            if (distance == 0 && r1 == r2) {
                System.out.println(-1);
            } else if (distance > d1 && distance < d2) {
                System.out.println(2);
            } else if (distance == d1 || distance == d2) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}

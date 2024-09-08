import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long x1 = sc.nextLong();
        long y1 = sc.nextLong();
        long x2 = sc.nextLong();
        long y2 = sc.nextLong();
        long x3 = sc.nextLong();
        long y3 = sc.nextLong();
        long x4 = sc.nextLong();
        long y4 = sc.nextLong();
        
        if (isIntersect(x1, y1, x2, y2, x3, y3, x4, y4)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        
        sc.close();
    }
    
    // 선분이 교차하는지 여부를 판단하는 함수
    public static boolean isIntersect(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
        int ccw1 = ccw(x1, y1, x2, y2, x3, y3);
        int ccw2 = ccw(x1, y1, x2, y2, x4, y4);
        int ccw3 = ccw(x3, y3, x4, y4, x1, y1);
        int ccw4 = ccw(x3, y3, x4, y4, x2, y2);

        // 선분이 서로 교차하는지 확인
        if (ccw1 * ccw2 <= 0 && ccw3 * ccw4 <= 0) {
            // 특수한 경우: 선분이 일직선 상에 있는 경우
            if (ccw1 == 0 && ccw2 == 0 && ccw3 == 0 && ccw4 == 0) {
                return isOverlapping(x1, y1, x2, y2, x3, y3, x4, y4);
            }
            return true;
        }
        return false;
    }

    // CCW (Counter ClockWise) 계산
    public static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long result = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
        if (result > 0) return 1;
        else if (result < 0) return -1;
        else return 0;
    }

    // 선분이 겹치는지 확인
    public static boolean isOverlapping(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
        if (Math.min(x1, x2) <= Math.max(x3, x4) && Math.min(x3, x4) <= Math.max(x1, x2)
            && Math.min(y1, y2) <= Math.max(y3, y4) && Math.min(y3, y4) <= Math.max(y1, y2)) {
            return true;
        }
        return false;
    }
}
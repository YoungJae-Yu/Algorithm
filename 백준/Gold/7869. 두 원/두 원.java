import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 두 원의 중심과 반지름 입력 받기
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double r1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        double r2 = sc.nextDouble();
        
        // 두 원의 중심 간 거리 계산
        double d = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        
        // 겹치는 넓이 계산
        double result = 0.0;
        
        // 원이 겹치지 않을 때
        if (d >= r1 + r2) {
            result = 0.0;
        }
        // 한 원이 다른 원을 완전히 포함하는 경우
        else if (d <= Math.abs(r1 - r2)) {
            double r = Math.min(r1, r2);
            result = Math.PI * r * r;
        }
        // 두 원이 일부 겹치는 경우
        else {
            double cosA = (r1 * r1 + d * d - r2 * r2) / (2 * r1 * d);
            double cosB = (r2 * r2 + d * d - r1 * r1) / (2 * r2 * d);
            
            double A = Math.acos(cosA) * 2;
            double B = Math.acos(cosB) * 2;
            
            double area1 = 0.5 * r1 * r1 * (A - Math.sin(A));
            double area2 = 0.5 * r2 * r2 * (B - Math.sin(B));
            
            result = area1 + area2;
        }
        
        // 결과 출력 (소수점 셋째 자리 반올림)
        System.out.printf("%.3f\n", result);
    }
}
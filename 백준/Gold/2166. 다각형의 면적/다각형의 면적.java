import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 다각형의 꼭짓점 수
        double[] x = new double[n];
        double[] y = new double[n];
        
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextDouble();
            y[i] = sc.nextDouble();
        }

        double area = 0;
        for (int i = 0; i < n - 1; i++) {
            area += x[i] * y[i + 1] - x[i + 1] * y[i];
        }
        area += x[n - 1] * y[0] - x[0] * y[n - 1];

        area = Math.abs(area) / 2.0;

        // 결과 출력 (소수점 1자리까지 출력)
        System.out.printf("%.1f\n", area);
        
        sc.close();
    }
}
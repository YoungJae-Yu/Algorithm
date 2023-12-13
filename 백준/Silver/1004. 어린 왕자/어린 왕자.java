import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 테스트 케이스의 개수

        for (int tc = 0; tc < T; tc++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int n = scanner.nextInt(); // 행성계의 개수

            int count = 0; // 행성계 진입/이탈 횟수

            for (int i = 0; i < n; i++) {
                int cx = scanner.nextInt();
                int cy = scanner.nextInt();
                int r = scanner.nextInt();

                // 출발점과 도착점이 행성계 내부에 있는 경우
                if (isInside(x1, y1, cx, cy, r) && isInside(x2, y2, cx, cy, r)) {
                    continue;
                }
                // 출발점과 도착점이 행성계 외부에 있는 경우
                if (!isInside(x1, y1, cx, cy, r) && !isInside(x2, y2, cx, cy, r)) {
                    continue;
                }
                // 나머지 경우
                count++;
            }

            System.out.println(count);
        }
    }

    // 점 (x, y)가 중심이 (cx, cy)이고 반지름이 r인 원 내부에 있는지 여부를 확인하는 함수
    public static boolean isInside(int x, int y, int cx, int cy, int r) {
        return (x - cx) * (x - cx) + (y - cy) * (y - cy) < r * r;
    }
}

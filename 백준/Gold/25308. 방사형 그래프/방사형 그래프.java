import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] stats = new int[8];      // 입력 능력치 배열
    static int[] perm = new int[8];      // 현재 순열
    static boolean[] used = new boolean[8]; // 사용 여부 체크
    static int count = 0;                // 볼록 순열 개수
    static final double[] angles = new double[8]; // 각도 배열 (0°, 45°, ..., 315°)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 능력치 입력
        for (int i = 0; i < 8; i++) {
            stats[i] = Integer.parseInt(st.nextToken());
        }

        // 각도 미리 계산 (0, π/4, π/2, ..., 7π/4)
        for (int i = 0; i < 8; i++) {
            angles[i] = 2 * Math.PI * i / 8;
        }

        // 순열 생성 시작
        generatePermutation(0);
        System.out.println(count);
    }

    // 순열 생성 함수
    static void generatePermutation(int depth) {
        if (depth == 8) {
            if (isConvex()) {
                count++;
            }
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!used[i]) {
                used[i] = true;
                perm[depth] = stats[i];
                generatePermutation(depth + 1);
                used[i] = false;
            }
        }
    }

    // 볼록성 확인 함수
    static boolean isConvex() {
        // 2D 좌표 계산
        double[][] points = new double[8][2];
        for (int i = 0; i < 8; i++) {
            double r = perm[i];          // 반지름 = 능력치
            double theta = angles[i];    // 각도
            points[i][0] = r * Math.cos(theta); // x좌표
            points[i][1] = r * Math.sin(theta); // y좌표
        }

        // 모든 연속된 세 점에 대해 외적 계산
        double firstCross = 0;
        for (int i = 0; i < 8; i++) {
            int a = i;
            int b = (i + 1) % 8;        // 다음 점 (원형 연결)
            int c = (i + 2) % 8;        // 다다음 점
            double cross = crossProduct(points[a], points[b], points[c]);

            // 첫 외적 값 저장
            if (i == 0) {
                firstCross = cross;
                // 외적이 0이면 직선이므로 볼록하지 않음
                if (Math.abs(cross) < 1e-10) {
                    return false;
                }
            } else {
                // 부호가 다르면 볼록하지 않음
                if (cross * firstCross < 0) {
                    return false;
                }
                // 외적이 0이면 직선이므로 볼록하지 않음
                if (Math.abs(cross) < 1e-10) {
                    return false;
                }
            }
        }
        return true;
    }

    // 외적 계산 함수 (2D 벡터 qp와 qr의 외적)
    static double crossProduct(double[] p, double[] q, double[] r) {
        double qp_x = q[0] - p[0];
        double qp_y = q[1] - p[1];
        double qr_x = r[0] - q[0];
        double qr_y = r[1] - q[1];
        return qp_x * qr_y - qp_y * qr_x;
    }
}
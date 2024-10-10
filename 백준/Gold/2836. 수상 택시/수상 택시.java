import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  // 승객의 수
        int m = Integer.parseInt(st.nextToken());  // 택시가 가야할 최종 목적지

        List<int[]> reversePassengers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (start > end) {
                reversePassengers.add(new int[]{end, start});
            }
        }

        // 역방향 승객을 끝점 기준으로 정렬
        reversePassengers.sort(Comparator.comparingInt(a -> a[0]));

        long totalDistance = m;  // 기본적으로 직선 거리는 m

        int left = -1, right = -1;
        for (int[] passenger : reversePassengers) {
            int curLeft = passenger[0];
            int curRight = passenger[1];

            if (right < curLeft) {  // 새로운 구간을 처리
                if (right != -1) {
                    totalDistance += 2 * (right - left);
                }
                left = curLeft;
                right = curRight;
            } else {
                right = Math.max(right, curRight);  // 구간을 확장
            }
        }

        if (right != -1) {
            totalDistance += 2 * (right - left);
        }

        System.out.println(totalDistance);
    }
}
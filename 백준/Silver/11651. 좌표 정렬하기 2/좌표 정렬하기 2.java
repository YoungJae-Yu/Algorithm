import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 점의 개수 N
        int[][] points = new int[N][2]; // 점을 저장할 2차원 배열
        
        // 점 입력 받기
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            points[i][0] = Integer.parseInt(input[0]); // x 좌표
            points[i][1] = Integer.parseInt(input[1]); // y 좌표
        }
        
        // 좌표 정렬 (y좌표 기준 정렬, y좌표가 같으면 x좌표 기준 정렬)
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                // y 좌표가 같으면 x 좌표로 비교
                if (point1[1] == point2[1]) {
                    return Integer.compare(point1[0], point2[0]);
                }
                // y 좌표로 비교
                return Integer.compare(point1[1], point2[1]);
            }
        });
        
        // 정렬된 좌표 출력
        StringBuilder sb = new StringBuilder();
        for (int[] point : points) {
            sb.append(point[0]).append(" ").append(point[1]).append("\n");
        }
        System.out.print(sb);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] lines = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }
        
        // 시작점을 기준으로 정렬, 시작점이 같으면 끝점을 기준으로 정렬
        Arrays.sort(lines, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        
        int start = lines[0][0];
        int end = lines[0][1];
        int totalLength = 0;
        
        for (int i = 1; i < n; i++) {
            if (lines[i][0] <= end) {
                // 현재 선분이 이전 선분과 겹치면 끝점을 병합
                end = Math.max(end, lines[i][1]);
            } else {
                // 겹치지 않으면 기존 선분의 길이를 더하고 새로운 선분으로 갱신
                totalLength += end - start;
                start = lines[i][0];
                end = lines[i][1];
            }
        }
        
        // 마지막으로 남은 선분의 길이 더하기
        totalLength += end - start;
        
        System.out.println(totalLength);
    }
}
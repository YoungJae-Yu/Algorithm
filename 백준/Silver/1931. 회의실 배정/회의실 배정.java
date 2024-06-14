import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] meetings = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            meetings[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }

        // 종료 시간 기준 오름차순 정렬, 종료 시간 같으면 시작 시간 기준 오름차순 정렬
        Arrays.sort(meetings, (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);

        int count = 0; // 선택된 회의 수
        int endTime = 0; // 이전 회의 종료 시간

        for (int[] meeting : meetings) {
            if (meeting[0] >= endTime) { // 이전 회의 종료 시간 이후에 시작하는 회의 선택
                count++;
                endTime = meeting[1]; // 종료 시간 갱신
            }
        }

        System.out.println(count);
    }
}

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] times = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times); // 오름차순 정렬

        int totalTime = 0;
        int accumulatedTime = 0;

        for (int time : times) {
            accumulatedTime += time; // 누적 시간 계산
            totalTime += accumulatedTime; // 총 시간에 누적 시간 더하기
        }

        System.out.println(totalTime);
    }
}

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 구간 합 계산 횟수

        int[] nums = new int[N + 1]; // 숫자 저장 (0번 인덱스는 사용하지 않음)
        int[] prefixSum = new int[N + 1]; // prefixSum[i]: 1부터 i까지의 합

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + nums[i]; // 누적 합 계산
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int sum = prefixSum[end] - prefixSum[start - 1]; // 구간 합 계산
            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

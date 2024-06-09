import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] S = new long[N + 1]; // 누적 합 저장 배열
        long[] remainderCount = new long[M]; // 나머지별 개수 저장 배열
        long result = 0; // 결과 (나머지가 0인 부분합 개수)

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            S[i] = (S[i - 1] + Integer.parseInt(st.nextToken())) % M;
            remainderCount[(int) S[i]]++; // 현재 누적 합의 나머지 개수 증가
            if (S[i] == 0) {
                result++; // 나머지가 0인 부분합 개수 증가
            }
        }

        // 나머지가 같은 두 누적합의 차는 M의 배수
        for (int i = 0; i < M; i++) {
            if (remainderCount[i] > 1) { // 나머지가 같은 누적합이 2개 이상인 경우
                result += (remainderCount[i] * (remainderCount[i] - 1)) / 2; // 조합 (nCr) 계산
            }
        }

        System.out.println(result);
    }
}

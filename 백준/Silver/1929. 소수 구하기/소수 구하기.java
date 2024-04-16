import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        boolean[] prime = new boolean[N+1]; // 소수 판별 배열
        fillPrimeArray(prime);

        // M 이상 N 이하의 소수 출력
        for (int i = M; i <= N; i++) {
            if (!prime[i]) { // 소수이면
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 에라토스테네스의 체를 사용하여 소수 배열 채우기
    public static void fillPrimeArray(boolean[] prime) {
        prime[0] = prime[1] = true; // 0과 1은 소수가 아님
        for (int i = 2; i * i < prime.length; i++) {
            if (!prime[i]) { // i가 소수일 경우
                for (int j = i * i; j < prime.length; j += i) {
                    prime[j] = true; // i의 배수는 소수가 아님
                }
            }
        }
    }
}

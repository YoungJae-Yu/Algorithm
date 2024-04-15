import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    // 최대공약수를 구하는 메소드
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 가로수의 개수
        int[] trees = new int[N]; // 가로수의 위치를 저장할 배열

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }

        int gap = trees[1] - trees[0]; // 초기 간격
        for (int i = 2; i < N; i++) {
            gap = gcd(gap, trees[i] - trees[i-1]);
        }

        int answer = 0;
        for (int i = 1; i < N; i++) {
            answer += (trees[i] - trees[i-1]) / gap - 1;
        }

        System.out.println(answer);
    }
}

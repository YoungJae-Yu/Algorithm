import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // N 이하의 소수 리스트 생성 (에라토스테네스의 체)
        boolean[] isPrime = new boolean[N + 1];
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        // 투 포인터로 연속된 소수의 합 계산
        int start = 0, end = 0, sum = 0, count = 0;

        while (true) {
            if (sum >= N) {
                sum -= primes.get(start++);
            } else if (end == primes.size()) {
                break;
            } else {
                sum += primes.get(end++);
            }

            if (sum == N) {
                count++;
            }
        }

        System.out.println(count);
    }
}
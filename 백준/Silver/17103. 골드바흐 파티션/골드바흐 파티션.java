import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 테스트 케이스의 수
        
        // 1,000,000까지의 모든 소수를 찾기 위해 에라토스테네스의 체를 사용
        boolean[] isPrime = new boolean[1000001];
        for (int i = 2; i <= 1000000; i++) {
            isPrime[i] = true;
        }
        
        for (int i = 2; i * i <= 1000000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= 1000000; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        
        // 테스트 케이스별로 골드바흐 파티션 계산
        while (T-- > 0) {
            int N = scanner.nextInt();
            int count = 0;
            
            // 소수 리스트를 이용한 골드바흐 파티션 계산
            for (int i = 0; i < primes.size(); i++) {
                if (primes.get(i) <= N / 2) {
                    if (isPrime[N - primes.get(i)]) {
                        count++;
                    }
                } else {
                    break;
                }
            }
            
            System.out.println(count);
        }
        
        scanner.close();
    }
}

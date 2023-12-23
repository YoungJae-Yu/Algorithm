import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 필요한 기타줄 수
        int M = scanner.nextInt(); // 브랜드 수
        int[] packagePrice = new int[M];
        int[] singlePrice = new int[M];

        for (int i = 0; i < M; i++) {
            packagePrice[i] = scanner.nextInt();
            singlePrice[i] = scanner.nextInt();
        }

        // 패키지 구매 vs 낱개 구매
        int minPackagePrice = Arrays.stream(packagePrice).min().orElse(1001);
        int minSinglePrice = Arrays.stream(singlePrice).min().orElse(1001);

        int minCost = Math.min(minPackagePrice * (N / 6) + minSinglePrice * (N % 6),
                Math.min(minPackagePrice * ((N / 6) + 1), minSinglePrice * N));

        System.out.println(minCost);
    }
}

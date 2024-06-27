import java.util.Scanner;

public class Main {
    // 주어진 길이로 랜선을 잘라서 얻을 수 있는 랜선의 개수를 계산하는 메서드
    private static long countLanCables(int[] cables, long length) {
        long count = 0;
        for (int cable : cables) {
            count += cable / length;
        }
        return count;
    }

    // 이분 탐색을 통해 최대 랜선 길이를 찾는 메서드
    private static long findMaxLength(int[] cables, int N) {
        long low = 1;
        long high = Integer.MAX_VALUE;
        long result = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            if (countLanCables(cables, mid) >= N) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int K = scanner.nextInt();
        int N = scanner.nextInt();
        int[] cables = new int[K];

        for (int i = 0; i < K; i++) {
            cables[i] = scanner.nextInt();
        }

        System.out.println(findMaxLength(cables, N));
    }
}
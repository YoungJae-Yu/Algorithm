import java.util.Scanner;

public class Main {
    // 주어진 높이로 나무를 잘라서 얻을 수 있는 나무의 길이를 계산하는 메서드
    private static long calculateWood(int[] trees, int height) {
        long total = 0;
        for (int tree : trees) {
            if (tree > height) {
                total += tree - height;
            }
        }
        return total;
    }

    // 이분 탐색을 통해 최대 절단기 높이를 찾는 메서드
    private static int findMaxHeight(int[] trees, int M) {
        int low = 0;
        int high = 0;
        for (int tree : trees) {
            if (tree > high) {
                high = tree;
            }
        }

        int result = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            long wood = calculateWood(trees, mid);

            if (wood >= M) {
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

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] trees = new int[N];

        for (int i = 0; i < N; i++) {
            trees[i] = scanner.nextInt();
        }

        System.out.println(findMaxHeight(trees, M));
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static long C;
    static long[] weights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N과 C를 입력받습니다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());

        // 물건들의 무게를 입력받습니다.
        weights = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Long.parseLong(st.nextToken());
        }

        // 물건들을 두 개의 부분으로 나눕니다.
        int n1 = N / 2;
        int n2 = N - n1;
        long[] weights1 = Arrays.copyOfRange(weights, 0, n1);
        long[] weights2 = Arrays.copyOfRange(weights, n1, N);

        // 각 부분의 부분집합 합을 구합니다.
        ArrayList<Long> sumList1 = new ArrayList<>();
        ArrayList<Long> sumList2 = new ArrayList<>();
        generateSubsets(weights1, sumList1);
        generateSubsets(weights2, sumList2);

        // 두 번째 부분의 합 리스트를 정렬합니다.
        Collections.sort(sumList2);

        // 유효한 조합의 수를 계산합니다.
        long total = 0;
        for (long sum1 : sumList1) {
            long remaining = C - sum1;
            total += upperBound(sumList2, remaining);
        }

        System.out.println(total);
    }

    // 부분집합의 합을 구하는 함수입니다.
    static void generateSubsets(long[] arr, ArrayList<Long> sumList) {
        int len = arr.length;
        int total = 1 << len; // 2의 len 제곱
        for (int i = 0; i < total; i++) {
            long sum = 0;
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += arr[j];
                }
            }
            if (sum <= C) {
                sumList.add(sum);
            }
        }
    }

    // upper bound를 찾는 함수입니다.
    static int upperBound(ArrayList<Long> list, long target) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; // target 이하의 원소 개수
    }
}
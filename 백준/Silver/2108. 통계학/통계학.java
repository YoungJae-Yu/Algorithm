import java.io.*;
import java.util.*;

/**
 * 통계학 문제를 해결하는 프로그램입니다.
 * 주어진 N개의 수에 대해 산술평균, 중앙값, 최빈값, 범위를 계산합니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위해 BufferedReader를 사용합니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int[] counts = new int[8001]; // -4000 ~ 4000 범위의 수를 저장하기 위한 배열

        long sum = 0; // 합계를 저장하기 위한 변수 (long 타입으로 선언하여 오버플로 방지)
        int min = 4001; // 최소값을 저장하기 위한 변수
        int max = -4001; // 최대값을 저장하기 위한 변수

        // 데이터를 입력받으면서 필요한 값들을 계산합니다.
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            numbers[i] = num;
            sum += num;
            counts[num + 4000]++; // 해당 숫자의 빈도 증가

            if (num < min) min = num;
            if (num > max) max = num;
        }

        // 산술평균 계산 (소수점 이하 첫째 자리에서 반올림)
        double average = (double) sum / N;
        int avg = (int) Math.round(average);
        if (avg == -0) avg = 0; // -0이 출력되는 것을 방지
        System.out.println(avg);

        // 중앙값 계산 (오름차순 정렬 후 중앙에 위치한 값 출력)
        Arrays.sort(numbers);
        int median = numbers[N / 2];
        System.out.println(median);

        // 최빈값 계산
        int maxFreq = 0; // 최대 빈도를 저장하는 변수
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > maxFreq) {
                maxFreq = counts[i];
            }
        }

        // 최대 빈도를 가진 숫자들을 저장하는 리스트
        ArrayList<Integer> modes = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == maxFreq) {
                modes.add(i - 4000); // 인덱스를 원래 숫자로 변환하여 추가
            }
        }

        // 최빈값 출력 (최빈값이 여러 개일 경우 두 번째로 작은 값 출력)
        Collections.sort(modes);
        int mode;
        if (modes.size() == 1) {
            mode = modes.get(0);
        } else {
            mode = modes.get(1);
        }
        System.out.println(mode);

        // 범위 계산 (최대값 - 최소값)
        int range = max - min;
        System.out.println(range);
    }
}

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 응시자 수
        int k = scanner.nextInt(); // 상을 받는 사람의 수
        Integer[] scores = new Integer[N]; // 점수를 저장할 배열, Integer로 선언하여 Collections.reverseOrder() 사용

        for (int i = 0; i < N; i++) {
            scores[i] = scanner.nextInt(); // 점수 입력
        }

        // 점수를 내림차순으로 정렬
        Arrays.sort(scores, Collections.reverseOrder());

        // 커트라인 출력
        System.out.println(scores[k - 1]); // 상을 받는 사람들 중 가장 낮은 점수

        scanner.close();
    }
}

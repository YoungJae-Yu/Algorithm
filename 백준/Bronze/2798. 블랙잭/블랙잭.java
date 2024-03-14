import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 카드의 개수
        int M = scanner.nextInt(); // 목표 합
        int[] cards = new int[N]; // 카드에 쓰여 있는 수를 저장할 배열

        for (int i = 0; i < N; i++) {
            cards[i] = scanner.nextInt(); // 카드에 쓰여 있는 수 입력 받기
        }

        System.out.println(blackjack(cards, N, M));
    }

    public static int blackjack(int[] cards, int N, int M) {
        int result = 0; // 최종 결과를 저장할 변수

        // 모든 카드 조합을 탐색
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = cards[i] + cards[j] + cards[k]; // 세 카드의 합
                    if (sum <= M && sum > result) { // 합이 M을 넘지 않으면서, 현재까지의 결과보다 큰 경우
                        result = sum; // 결과 업데이트
                    }
                }
            }
        }

        return result; // 최종 결과 반환
    }
}

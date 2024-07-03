import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 명령의 개수

        // 절댓값 힙을 구현하기 위해 PriorityQueue 사용
        PriorityQueue<Integer> absHeap = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            if (absA == absB) {
                return Integer.compare(a, b);
            } else {
                return Integer.compare(absA, absB);
            }
        });

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();

            if (x == 0) {
                if (absHeap.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(absHeap.poll());
                }
            } else {
                absHeap.add(x);
            }
        }
    }
}
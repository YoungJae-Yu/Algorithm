import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static final int MAX = 100001;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        
        int[] time = new int[MAX];
        boolean[] visited = new boolean[MAX];
        
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(N);
        visited[N] = true;
        
        while (!deque.isEmpty()) {
            int current = deque.poll();
            
            if (current == K) {
                System.out.println(time[current]);
                return;
            }
            
            // 순간 이동 (0초 소요)
            if (current * 2 < MAX && !visited[current * 2]) {
                deque.addFirst(current * 2);
                visited[current * 2] = true;
                time[current * 2] = time[current];
            }
            
            // -1 이동 (1초 소요)
            if (current - 1 >= 0 && !visited[current - 1]) {
                deque.addLast(current - 1);
                visited[current - 1] = true;
                time[current - 1] = time[current] + 1;
            }
            
            // +1 이동 (1초 소요)
            if (current + 1 < MAX && !visited[current + 1]) {
                deque.addLast(current + 1);
                visited[current + 1] = true;
                time[current + 1] = time[current] + 1;
            }
        }
    }
}
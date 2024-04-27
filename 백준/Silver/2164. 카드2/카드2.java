import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        Queue<Integer> queue = new LinkedList<>();
        
        // 초기 카드 준비
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        
        while (queue.size() > 1) {
            queue.poll(); // 제일 위의 카드를 버린다.
            queue.offer(queue.poll()); // 그 다음 카드를 제일 아래로 옮긴다.
        }
        
        System.out.println(queue.poll()); // 마지막으로 남은 카드를 출력한다.
    }
}

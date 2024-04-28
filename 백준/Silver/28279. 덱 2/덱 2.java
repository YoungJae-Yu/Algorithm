import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");
            
            switch (command[0]) {
                case "1":
                    deque.addFirst(Integer.parseInt(command[1]));
                    break;
                case "2":
                    deque.addLast(Integer.parseInt(command[1]));
                    break;
                case "3":
                    sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append('\n');
                    break;
                case "4":
                    sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append('\n');
                    break;
                case "5":
                    sb.append(deque.size()).append('\n');
                    break;
                case "6":
                    sb.append(deque.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "7":
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append('\n');
                    break;
                case "8":
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append('\n');
                    break;
            }
        }
        
        System.out.print(sb);
    }
}

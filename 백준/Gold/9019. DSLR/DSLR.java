import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            boolean[] visited = new boolean[10000];
            int[] from = new int[10000];
            char[] how = new char[10000];
            
            Queue<Integer> queue = new LinkedList<>();
            
            queue.offer(A);
            visited[A] = true;
            from[A] = -1; // 시작점 표시
            
            while(!queue.isEmpty()) {
                int current = queue.poll();
                
                if(current == B) {
                    break;
                }
                
                // D 연산
                int D = (current * 2) % 10000;
                if(!visited[D]) {
                    visited[D] = true;
                    from[D] = current;
                    how[D] = 'D';
                    queue.offer(D);
                }
                
                // S 연산
                int S = (current == 0) ? 9999 : current -1;
                if(!visited[S]) {
                    visited[S] = true;
                    from[S] = current;
                    how[S] = 'S';
                    queue.offer(S);
                }
                
                // L 연산
                int L = (current % 1000) * 10 + (current / 1000);
                if(!visited[L]) {
                    visited[L] = true;
                    from[L] = current;
                    how[L] = 'L';
                    queue.offer(L);
                }
                
                // R 연산
                int R = (current % 10) * 1000 + (current / 10);
                if(!visited[R]) {
                    visited[R] = true;
                    from[R] = current;
                    how[R] = 'R';
                    queue.offer(R);
                }
            }
            
            StringBuilder result = new StringBuilder();
            int idx = B;
            while(idx != A) {
                result.append(how[idx]);
                idx = from[idx];
            }
            sb.append(result.reverse().toString()).append('\n');
        }
        
        System.out.print(sb.toString());
    }
}
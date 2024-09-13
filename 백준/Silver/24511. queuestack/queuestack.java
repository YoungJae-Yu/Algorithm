import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N 입력 및 초기화
        int N = Integer.parseInt(br.readLine());
        String[] A_input = br.readLine().split(" ");
        String[] B_input = br.readLine().split(" ");
        
        // 큐 자료구조의 초기 원소를 저장할 Deque 생성
        Deque<Integer> queue = new ArrayDeque<>();
        
        // 자료구조가 큐인 경우 초기 원소를 역순으로 Deque에 추가 (addLast로 변경)
        for (int i = N - 1; i >= 0; i--) {
            int A_i = Integer.parseInt(A_input[i]);
            int B_i = Integer.parseInt(B_input[i]);
            if (A_i == 0) { // 큐인 경우
                queue.addLast(B_i);
            }
        }
        
        // M 및 C 입력
        int M = Integer.parseInt(br.readLine());
        String[] C_input = br.readLine().split(" ");
        
        // 결과를 저장할 StringBuilder
        StringBuilder sb = new StringBuilder();
        
        // 연산 처리
        for (int i = 0; i < M; i++) {
            int Ci = Integer.parseInt(C_input[i]);
            if (!queue.isEmpty()) {
                int output = queue.pollFirst();
                sb.append(output).append(" ");
                queue.addLast(Ci);
            } else {
                sb.append(Ci).append(" ");
            }
        }
        
        // 결과 출력
        System.out.println(sb.toString().trim());
    }
}
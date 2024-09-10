import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int M = Integer.parseInt(br.readLine());
        int S = 0;  // 공집합을 0으로 초기화 (비트마스크 사용)
        
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            if (command.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                S |= (1 << x);  // x번째 비트 1로 설정
                
            } else if (command.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                S &= ~(1 << x);  // x번째 비트 0으로 설정
                
            } else if (command.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                sb.append((S & (1 << x)) != 0 ? 1 : 0).append("\n");  // x번째 비트가 1인지 확인
                
            } else if (command.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                S ^= (1 << x);  // x번째 비트를 토글
                
            } else if (command.equals("all")) {
                S = (1 << 21) - 1;  // 1부터 20까지 모두 포함
                
            } else if (command.equals("empty")) {
                S = 0;  // 공집합으로 설정
            }
        }
        
        System.out.print(sb);
    }
}
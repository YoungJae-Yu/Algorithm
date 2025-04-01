import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while(true) {
            st = new StringTokenizer(br.readLine());
            List<Integer> numbers = new ArrayList<>();
            
            // 입력 받기
            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if(num == -1) return; // -1이면 프로그램 종료
                if(num == 0) break;   // 0이면 다음 테스트 케이스로
                numbers.add(num);
            }
            
            // 종료 조건 체크 (0으로 끝나는 경우)
            if(numbers.isEmpty()) continue;
            
            // 두 배인 숫자 쌍 세기
            int count = 0;
            for(int i = 0; i < numbers.size(); i++) {
                int current = numbers.get(i);
                for(int j = 0; j < numbers.size(); j++) {
                    if(i != j && current == numbers.get(j) * 2) {
                        count++;
                    }
                }
            }
            
            System.out.println(count);
        }
    }
}
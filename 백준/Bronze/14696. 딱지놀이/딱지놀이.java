import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 라운드 수
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < N; i++) {
            // A와 B의 카드 개수를 저장할 배열 (인덱스 1~4 사용)
            int[] countA = new int[5];
            int[] countB = new int[5];
            
            // A의 카드 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 카드 개수
            for(int j = 0; j < a; j++) {
                countA[Integer.parseInt(st.nextToken())]++;
            }
            
            // B의 카드 입력
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken()); // 카드 개수
            for(int j = 0; j < b; j++) {
                countB[Integer.parseInt(st.nextToken())]++;
            }
            
            // 4부터 1까지 비교
            char result = 'D'; // 기본값은 무승부
            for(int k = 4; k >= 1; k--) {
                if(countA[k] > countB[k]) {
                    result = 'A';
                    break;
                } else if(countA[k] < countB[k]) {
                    result = 'B';
                    break;
                }
            }
            sb.append(result).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}
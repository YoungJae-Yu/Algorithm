import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        // 상근이가 가지고 있는 숫자 카드를 해시 맵에 저장
        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(st.nextToken());
            map.put(key, 1); // 존재하는 숫자 카드에 대해서는 value를 1로 설정
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        
        // M개의 숫자에 대하여 상근이가 해당 숫자 카드를 가지고 있는지 확인
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            if (map.containsKey(key)) {
                sb.append("1 "); // 숫자 카드가 존재하면 1 출력
            } else {
                sb.append("0 "); // 숫자 카드가 존재하지 않으면 0 출력
            }
        }
        
        System.out.println(sb.toString().trim()); // 결과 출력
    }
}

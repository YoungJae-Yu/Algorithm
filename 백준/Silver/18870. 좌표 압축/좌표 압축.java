import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] original = new int[N]; // 원본 좌표 배열
        Integer[] sorted = new Integer[N]; // 정렬될 좌표 배열 (복사본)
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            original[i] = Integer.parseInt(st.nextToken());
            sorted[i] = original[i];
        }
        
        Arrays.sort(sorted); // 복사본 배열 정렬
        
        // 좌표에 대한 순위를 저장할 Map
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < N; i++) {
            if (!rankMap.containsKey(sorted[i])) {
                rankMap.put(sorted[i], rank++);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(rankMap.get(original[i])).append(" ");
        }
        
        System.out.println(sb);
    }
}

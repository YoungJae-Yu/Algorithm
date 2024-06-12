import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        
        int[][] count = new int[26][S.length() + 1]; // 각 알파벳에 대한 누적 합 배열
        
        // 누적 합 계산
        for (int i = 0; i < S.length(); i++) {
            count[S.charAt(i) - 'a'][i + 1]++;
            for (int j = 0; j < 26; j++) {
                count[j][i + 1] += count[j][i];
            }
        }
        
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        // 질문 처리
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char alpha = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            
            sb.append(count[alpha - 'a'][r + 1] - count[alpha - 'a'][l]).append('\n');
        }
        
        System.out.print(sb);
    }
}
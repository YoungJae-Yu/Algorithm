import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String S = br.readLine();
        int q = Integer.parseInt(br.readLine());
        int[][] count = new int[26][S.length() + 1]; // 각 알파벳에 대한 누적 합 배열
        
        // 누적 합 계산
        for (int i = 0; i < S.length(); i++) {
            count[S.charAt(i) - 'a'][i + 1]++;
            for (int j = 0; j < 26; j++) {
                count[j][i + 1] += count[j][i];
            }
        }
        
        // 질문 처리
        for (int i = 0; i < q; i++) {
            String[] query = br.readLine().split(" ");
            char alpha = query[0].charAt(0);
            int l = Integer.parseInt(query[1]);
            int r = Integer.parseInt(query[2]);
            
            System.out.println(count[alpha - 'a'][r + 1] - count[alpha - 'a'][l]);
        }
    }
}

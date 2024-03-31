import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        // 집합 S를 저장할 HashSet 생성
        HashSet<String> set = new HashSet<>();
        
        // 집합 S에 포함된 문자열을 HashSet에 저장
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        
        int count = 0; // 집합 S에 포함되어 있는 문자열의 개수를 세기 위한 변수
        // M개의 문자열 중 집합 S에 포함되어 있는지 확인
        for (int i = 0; i < M; i++) {
            if (set.contains(br.readLine())) {
                count++;
            }
        }
        
        // 결과 출력
        System.out.println(count);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        
        while (true) {
            line = br.readLine();
            
            // 입력의 끝 확인
            if (line.equals("#")) {
                break;
            }

            // 대소문자 구분 없이 소문자로 변환
            line = line.toLowerCase();

            int vowelCount = 0;
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowelCount++;
                }
            }
            
            // 결과 출력
            System.out.println(vowelCount);
        }
    }
}
